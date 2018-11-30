from django.shortcuts import render, redirect
from .forms import SignUpForm
from django.contrib.auth import login as auth_login


# Create your views here.
def signup(request):
	
	if request.method=='POST':
		form=SignUpForm(request.POST)
		if form.is_valid():
			user=form.save()
			user.backend='django.contrib.auth.backends.ModelBackend'
			user.save()
			auth_login(request,user)
			return redirect('hello')
	else:
		form=SignUpForm()
	return render(request,'signup.html',{'form':form})
