FROM python:3.9

WORKDIR /opt/module/django-example

ADD . /opt/module/django-example

RUN pip3 install -i https://pypi.tuna.tsinghua.edu.cn/simple -r requirements.txt

EXPOSE 8080

CMD python3 manage.py runserver 0.0.0.0:8080