import csv,io
from time import sleep

from django.contrib import messages
from django.shortcuts import render, get_object_or_404, redirect, render_to_response
from django.http import HttpResponse,HttpResponseRedirect
from django.views.decorators.csrf import csrf_exempt
from django.core.validators import email_re
from models import addEmployee
from django.template import RequestContext
from django.views.generic import View
from django.db.models import Q

# Create your views here.
class header(View):

  def get(self,request):
      return render(request,'header.html')

class welcome(View):
    template_name = "welcome.html"

    def get(self, request, *args, **kwargs):
        return render(request, self.template_name)

@csrf_exempt
def addEmp(request):
    if request.is_ajax():
        name=request.POST.get('uname')
        email=request.POST.get('email')
        phonenum=request.POST.get('phonenum')
        success=addEmployee(username=name,email=email,mobilenumber=phonenum)
        if(success.save()):
            return HttpResponse(200)
    return render(request,'addemployee.html',{})

def viewEmp(request):
    if (addEmployee.objects.count()):
        allemployees = addEmployee.objects.all()
        return render(request,'viewemployee.html',{'allemployees':allemployees})
    else:
        context={'norecords':"No records found"}
        return render(request,'viewemployee.html',context)
@csrf_exempt
def deleteEmp(request,data_id):
    print(data_id)
    deleteitem = get_object_or_404(addEmployee, pk=data_id)
    deleteitem.delete()
    return HttpResponse(200)

def updateEmp(request,data_id):
    updateitems=get_object_or_404(addEmployee,pk=data_id)
    return render(request,'updateform.html',{'updateitems':updateitems})

@csrf_exempt
def update(request):
    if request.is_ajax():
        addEmployee.objects.filter(email=request.POST.get('email')).update(username=request.POST.get('uname'), mobilenumber=request.POST.get('phonenum'))
        return HttpResponse(200)

def searchdata(request):
    return render(request,'searchform.html')


def searchcontent(request):
        dataemp=request.GET['searchtxt']

        allemployees=addEmployee.objects.filter(Q(username__icontains=dataemp) | Q(email__icontains=dataemp) | Q(mobilenumber__icontains=dataemp))
        if (dataemp==''):
            return redirect('/searchform/')
        flag="not found"
        for data in allemployees:
            if dataemp in data.username or dataemp in data.email or dataemp in data.mobilenumber :
                flag="found"
        if flag=="found":
            return render(request,'searchcontent.html',{'allemployees':allemployees,'dataemp':dataemp})
        else:
            return render(request,'searchform.html',{'msg':'No records found'})

def downloadform(request):
    if request.method == "GET":
         return render(request,'downloadform.html')

    items = addEmployee.objects.all()

    response = HttpResponse(content_type='text/csv')
    response['Content-Disposition'] = 'attachment; filename="Employee_csv.csv"'

    writer = csv.writer(response, delimiter=',')
    writer.writerow(['username', 'email', 'mobilenumber'])
    for obj in items:
        writer.writerow([obj.username, obj.email, obj.mobilenumber])

    return response

def uploadform(request):
    template = "uploadform.html"

    prompt = {
        'order': "Order of csv should be username, email, mobilenumber"
    }
    if request.method == "GET":
        return render(request, template, prompt)
    try:
        csv_file = request.FILES['file']

        if not csv_file.name.endswith('.csv'):
                messages.error(request, "<span style="'color:red;text-align:center'">This file is not a .csv file</span>")
        else:
            data_set = csv_file.read().decode('utf-8')
            io_string = io.StringIO(data_set)
            next(io_string)

            for column in csv.reader(io_string, delimiter=','):
                try:
                    name = column[0]
                    emailId = column[1]
                    mobile = column[2]
                    try:
                        if len(mobile)==10 and emailcheck(emailId) and not name.isdigit() and mobile.isdigit():
                            created = addEmployee(username=name, email=emailId, mobilenumber=mobile)
                            created.save()
                        else:
                            messages.error(request,"<span style="'color:red;text-align:center'">Not a valid data </span>")
                    except:
                        messages.error(request,"<span style="'color:red;align:center'">email already exist %s </span>" % emailId)
                        return redirect('/uploadform/')

                except:
                    return HttpResponseRedirect('/viewemployee')
    except:
        messages.error(request,"<span style="'color:red;'">please upload a file</span>")
        return HttpResponseRedirect('/uploadform/')

    context = {}
    return render(request, template, context)


def emailcheck(emailID):
    if  email_re.match(emailID):
        return True
    return False