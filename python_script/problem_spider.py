#-*- coding: utf-8 -*-

import urllib2
import MySQLdb
import re

import datetime
from bs4 import BeautifulSoup
headers = {
    'User-Agent':'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6'
}
problem_id=1005

url = "http://acm.hdu.edu.cn/showproblem.php?pid=%dn" %(problem_id)
request = urllib2.Request(
    url = url,
    headers = headers
)
response = urllib2.urlopen(request)
soup = BeautifulSoup(response,'lxml')
select=soup.select('.panel_content')


Problem_Description=select[0].get_text()
Now_Date=datetime.datetime.now()


#reg1 = re.compile("<[^>]*>")
#Problem_Description = reg1.sub('',Problem_Description)

reg2=re.compile("Time Limit: [0-9]*/[0-9]* MS")
reg3=re.compile("Memory Limit: [0-9]*/[0-9]* K")
reg4=re.compile("Total Submission\(s\): [0-9]*")
reg5=re.compile("Accepted Submission\(s\): [0-9]*")
reg6=re.compile("/[0-9]*")

Time_Limit = re.search(reg2,str(soup.span)).group()
Time_Limit = re.search(reg6,str(Time_Limit)).group().replace('/','')
Memory_Limit= re.search(reg3,str(soup.span)).group()
Memory_Limit = re.search(reg6,str(Memory_Limit)).group().replace('/','')
Total_Submission= re.search(reg4,str(soup.span)).group().replace('Total Submission(s): ','')
Accepted_Submission= re.search(reg5,str(soup.span)).group().replace('Accepted Submission(s): ','')

print 'Time_Limit:  ',Time_Limit
print 'Memory_Limit:  ',Memory_Limit
print 'Total_Submission:  ',Total_Submission
print 'Accepted_Submission:  ',Accepted_Submission

Title=soup.h1.get_text()
Input=select[1].get_text()
Output=select[2].get_text()
Sample_Input=select[3].get_text()
Sample_Output=select[4].get_text()
Author=select[5].get_text()
Recommend=select[6].get_text()

print 'Date:  ',Now_Date
print 'Title:  ',Title
print 'Problem_Description:  ',Problem_Description
print 'Input:  ',Input
print 'Output:  ',Output
print 'Sample_Input:  ',Sample_Input
print 'Sample_Output:  ',Sample_Output
print 'Author:  ',Author
print 'Recommend:  ',Recommend


# 打开数据库连接
db = MySQLdb.connect("localhost","root","","zjgsu_oj" )

# 使用cursor()方法获取操作游标
cursor = db.cursor()

# SQL 插入语句
sql = """INSERT INTO problem(problem_id,title,description,input,output,sample_input,sample_output,
         source,in_date,time_limit,memory_limit,hint,accepted,submit)
         VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"""
try:
    param = (
             problem_id,
             Title,
             Problem_Description,
             Input,
             Output,
             Sample_Input,
             Sample_Output,
             Author,
             Now_Date,
             Time_Limit,
             Memory_Limit,
             Recommend,
             Accepted_Submission,
             Total_Submission
             )
    # 执行sql语句
    cursor.execute(sql,param)
    # 提交到数据库执行
    db.commit()
    print 'Insert DB Success!'
except Exception,e:
    # Rollback in case there is any error
    print 'error',e
    db.rollback()

# 关闭数据库连接
db.close()