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

global username,password
global pro_id

headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER'
}


language={  'g++':'0',
            'gcc':'1',
            'c++':'2',
            'c':'3',
            'pascal':'4',
            'java':'5',
            'c#':'6',
            'cpp':'0'

}

start_pro = 1000
end_pro = 5000


def login():

    username=raw_input("please input username:\n")
    password=raw_input("please input password:\n")
    # type: () -> object

    login_info={
        'username':username.strip(),
        'userpass':password.strip(),
    }

    hdu_url = 'http://acm.hdu.edu.cn/userloginex.php?action=login'

    login_info=urllib.urlencode(login_info)

    co= cookielib.LWPCookieJar()
    opener=urllib2.build_opener(urllib2.HTTPCookieProcessor(co))

    hdu_session=urllib2.Request(hdu_url,login_info,headers)
    try:
        loginin=opener.open(hdu_session).read()
    except:
        print'请检查网络是否联通'


    if(loginin.find('No such user or wrong password.')!=-1):
        print 'No such user or wrong password.'
        exit()

    headers['Cookie'] = re.search('PHPSESSID=[A-Za-z0-9_]*', str(co)).group()  # 提取cookie
    print 'Login success'

    return



def status (pro_id):
    global qian_id, headers
    status_url = 'http://acm.hdu.edu.cn/status.php?user=' + qian_id
    req = urllib2.Request(status_url, urllib.urlencode({}), headers)

    while(True):
        time.sleep(1)

        html=urllib2.urlopen(req).read()
        soup=BeautifulSoup(html,'lxml')
        for i in soup.table.find_all('table')[-2].find_add('tr'):
            ans=i.find_all['td']
            if(ans[3].string==pro_id):
                dan=ans[2].string
                if(dan!='Queuing'and dan!='Comiling'):
                    print dan
                    return
                break


def submit_code(final_code):
    global headers

    # POST
    submit_url = 'http://acm.hdu.edu.cn/submit.php?action=submit'

    sesson = requests.Session()
    sesson.headers.update(headers)

    try:
        code = final_code  # 最终代码

        if code == None:
            return

        try:
            if (code.find('main') != -1):  # 如果代码中有main函数
                # POST数据
                post_data = {
                    'problemid': pro_id,
                    'usercode': code,
                    'language': language[code.get('class')[0]]
                }
                # 需要给Post数据编码
                postData = urllib.urlencode(post_data)
                request = urllib2.Request(submit_url, postData, headers)
                print 'post ' + pro_id
                urllib2.urlopen(request)
                # status(pro_id)
                f = open('ac.txt', 'a+')
                f.write(pro_id + '  ')
                f.close()
                print '------------------ ' + pro_id + ' Submit successfully\n'
        except KeyError, TypeError:
            print 'KeyError'

    except urllib2.URLError:  # 异常情况
        print 'URLError'






if __name__ == '__main__':
    print sys.path
    print 'test jython'
    reload(sys)
    login()
    submit_code("final_code")