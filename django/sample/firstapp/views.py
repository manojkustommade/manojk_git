from django.http import HttpResponse
from django.shortcuts import render, redirect, get_object_or_404
from .models import Board, Topic, Post
from django.contrib.auth.models import User
from .forms import NewTopicForm
from django.contrib.auth.decorators import login_required

def hello(request):
    boards = Board.objects.all()
    return render(request, 'hello.html', {'boards': boards})


def board_topics(request, pk):
	boards=get_object_or_404(Board,pk=pk)
	return render(request,'topic.html',{'boards':boards})

@login_required
def new_topic(request, pk):
    boards = get_object_or_404(Board, pk=pk)
    if request.method == 'POST':
        form = NewTopicForm(request.POST)
        if form.is_valid():
            topic = form.save(commit=False)
            topic.board = boards
            topic.starter = request.user
            topic.save()
            post = Post.objects.create(
                message=form.cleaned_data.get('message'),
                topic=topic,
                created_by=request.user
            )
            return redirect('board_topics', pk=boards.pk)  # TODO: redirect to the created topic page
    else:
        form = NewTopicForm()
    return render(request, 'new_topic.html', {'boards': boards, 'form': form})

def topic_posts(request,pk,topic_pk):
    topic=get_object_or_404(Topic, board__pk=pk, pk=topic_pk)
    return render(request,'topic_posts.html',{'topic':topic})