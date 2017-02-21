# -*- coding=utf-8  -*-

import cookielib
import threading
import urllib

import re

import time

import requests
from  bs4 import BeautifulSoup
import sys
import urllib2

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER'
}

language = {'g++': '0',
            'gcc': '1',
            'c++': '2',
            'c': '3',
            'pascal': '4',
            'java': '5',
            'c#': '6',
            'cpp': '0'

            }

start_pro = 1000
end_pro = 5000


def login():
    global username
    username = 'ginxidx'
    global password
    password = '123456'
    # username=raw_input("please input username:\n")
    # password=raw_input("please input password:\n")
    # type: () -> object

    login_info = {
        'username': username.strip(),
        'userpass': password.strip(),
    }

    hdu_url = 'http://acm.hdu.edu.cn/userloginex.php?action=login'

    login_info = urllib.urlencode(login_info)

    co = cookielib.LWPCookieJar()
    opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(co))

    hdu_session = urllib2.Request(hdu_url, login_info, headers)
    try:
        loginin = opener.open(hdu_session).read()
    except:
        print'请检查网络是否联通'

    if (loginin.find('No such user or wrong password.') != -1):
        print 'No such user or wrong password.'
        exit()

    headers['Cookie'] = re.search('PHPSESSID=[A-Za-z0-9_]*', str(co)).group()  # 提取cookie
    print 'Login success'

    return


def status(pro_id):
    global headers
    status_url = 'http://acm.hdu.edu.cn/status.php?user=' + username
    req = urllib2.Request(status_url, urllib.urlencode({}), headers)

    while (True):
        time.sleep(1)
        print 'finding status......'
        html = urllib2.urlopen(req).read()
        soup = BeautifulSoup(html, 'lxml')

        for i in soup.table.find_all('table')[-2].find_all('tr'):
            ans = i.find_all('td')
            if (ans[3].string == pro_id):
                dan = ans[2].string
                if (dan != 'Running' and dan != 'Compiling' and dan!='Queuing'):
                    print dan
                    print ans[4].string
                    print ans[5].string
                    return
                break


def submit_code(pro_id,sub_language,code):

    '''
        注意\n的处理
    '''

    '''
    final_code = #include<stdio.h>
    int main()
    {
    int a,b;
    while(scanf("%d%d",&a,&b)!=EOF)
    printf("%d\\n",a+b);
    return 0;
    }
    '''
    # pro_id = raw_input("please input pro_id:\n")
    # final_code = raw_input("please input code:\n")
    # sub_language = raw_input("please input sub_language:\n")

    global headers

    # POST
    submit_url = 'http://acm.hdu.edu.cn/submit.php?action=submit'

    sesson = requests.Session()
    sesson.headers.update(headers)

    try:

        if code == None:
            return

        try:
            # POST数据
            post_data = {
                'problemid': pro_id,
                'usercode': code,
                'language': sub_language
            }
            # 需要给Post数据编码
            postData = urllib.urlencode(post_data)
            request = urllib2.Request(submit_url, postData, headers)
            print 'post ' + pro_id
            urllib2.urlopen(request)
            status(pro_id)
            print '------------------ ' + pro_id + ' Submit successfully\n'
            
        except KeyError, TypeError:
            print 'KeyError'

    except urllib2.URLError:  # 异常情况
        print 'URLError'


if __name__ == '__main__':
    print 'submit code start'
    reload(sys)
    login()
    pro_id=raw_input('please input problem id\n')
    sub_language=raw_input('please input language\n')
    print 'please input your code\n'
    code =''
    stopWord = '###CODEEND'
    for line in iter(raw_input, stopWord):
        code += line + '\n'
    submit_code(pro_id,sub_language,code)
