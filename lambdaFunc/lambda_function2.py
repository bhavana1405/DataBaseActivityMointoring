import requests
import json
import logging
import os
import urllib3

urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)

# warnings.filterwarnings('ignore',message='Unverified HTTPS request')
logging.basicConfig(level=logging.INFO,format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')

def lambda_handler(event, context):
    url="http://dam-handler.dam.aws.edu:8080/api/dam"
    response=requests.get(url = url,verify=false)
    logging.critical("Response"+str(response.status_code))
    if response.ok:
        logging.info("Request successful")
    else:
        logging.critical("request failed with code "+str(response.status_code))

