import json
import gzip
import base64
import sys
import logging
import pymysql
from random import randint

rds_host = "database-lambda.cdjshxmafha8.us-east-1.rds.amazonaws.com"
name = "admin"
password = "password"
db_name = "dam"

logger = logging.getLogger()
logger.setLevel(logging.INFO)

try:
    conn = pymysql.connect(rds_host, user=name, passwd=password, db=db_name, connect_timeout=5)
except pymysql.MySQLError as e:
    logger.error("ERROR: Unexpected error: Could not connect to MySQL instance.")
    logger.error(e)
    sys.exit()

logger.info("SUCCESS: Connection to RDS MySQL instance succeeded")


def lambda_handler(event, context):
    
    print(event)
    cw_data = event['awslogs']['data']
    print(f'data: {cw_data}')
    print(f'type: {type(cw_data)}')
    compressed_payload = base64.b64decode(cw_data)
    uncompressed_payload = gzip.decompress(compressed_payload)
    payload = json.loads(uncompressed_payload)



    log_events = payload['logEvents']
    print(log_events)

    for log_event in log_events:
        
        print(log_event)
        cw_docbLogs = log_event['message']
        resp = json.loads(cw_docbLogs)
        cw_atype = resp["atype"]
        if cw_atype == "authenticate" :
            id=randint(100000, 999999)
            new_ts = int(str(resp['ts']) + str(id))
            cw_remote_ip = resp['remote_ip']
            cw_user = resp['user']
            cw_param = resp['param']
            cw_docb_user = cw_param['user']
       
            cw_mechanism = cw_param['mechanism']
            cw_success = cw_param['success']
            cw_message = cw_param['message']
            cw_error = cw_param['error']
            item_count = 0
            with conn.cursor() as cur:
                cur.execute("INSERT INTO cw_logs_stream (id,atype,ts,remote_ip,user,auth_user,mechanism,success,message,error,active_indicator,ddl_events) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)", (id,cw_atype,new_ts,cw_remote_ip,cw_user,cw_docb_user,cw_mechanism,cw_success,cw_message,cw_error,'Y','authenticate'))
                conn.commit()
                print("successfully inserted ")
        else:
            id=randint(100000, 999999)
            new_ts = int(str(resp['ts']) + str(id))
            cw_remote_ip = resp['remote_ip']
            cw_user = resp['user']
            cw_param = resp['param']
            cw_docb_user = cw_param['ns']
            item_count = 0
            with conn.cursor() as cur:
                value = None
                cur.execute("INSERT INTO cw_logs_stream (id,atype,ts,remote_ip,user,auth_user,mechanism,success,message,error,active_indicator,ddl_events) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)", (id,cw_atype,new_ts,cw_remote_ip,cw_user,cw_docb_user,value,value,value,value,'Y','authenticate'))
                conn.commit()
                print("successfully inserted ")
    return {
        'statusCode': 200,
        'body': json.dumps('Hello from Lambda!')
    }


