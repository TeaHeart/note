# Generated by Django 3.2.25 on 2024-05-27 06:21

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Admin',
            fields=[
                ('id', models.AutoField(primary_key=True, serialize=False, verbose_name='编号')),
                ('username', models.CharField(max_length=32, unique=True, verbose_name='用户名')),
                ('password', models.CharField(max_length=32, verbose_name='密码')),
            ],
        ),
        migrations.CreateModel(
            name='Group',
            fields=[
                ('id', models.AutoField(primary_key=True, serialize=False, verbose_name='编号')),
                ('name', models.CharField(max_length=32, verbose_name='组名')),
            ],
        ),
        migrations.CreateModel(
            name='User',
            fields=[
                ('id', models.AutoField(primary_key=True, serialize=False, verbose_name='编号')),
                ('username', models.CharField(max_length=32, verbose_name='用户名')),
                ('create_time', models.DateField(verbose_name='创建时间')),
                ('gender', models.SmallIntegerField(choices=[(0, '女'), (1, '男')], verbose_name='性别')),
                ('group', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='domain.group', verbose_name='组')),
            ],
        ),
    ]