# DataBaseActivityMointoring

AWS Resources created :


Document Db (No sql database ) – mongo db compatible :
POC done on document db resource in AWS .

Cloudwatch Logs

Created 2 log groups in cloud watch to get the logs from mongo
db which can be analyzed by lambda function. These logs contain all the
system level and app level activities which are monitored by lambda
function.

Logs from mongo db will be pushed to the CloudWatch logs which has two streams :
1. Audit
2. Profiler

Lambda function

Lambda function is created , which is self-triggered when the logs are output to the
CloudWatch logs .

Rds – Aurora mysql

Created RDS database and  table created to store the logs , once the logs is parsed in json and put in the table in tabular format.

Working Description:

Document DB , once the audit is enable ,all the logs will be captured in cloud watch logs .
Events categories like Connection,DDL,User Management and authorization will be captured which will be in json format . Lambda function will be scheduled to run for every 5 min , which will take the data from cloud watch and put into the RDS .

Once new record is ingested , other lambda will be triggered and analyze data , and finally end users is notified , if something suspicious is found .

AWS DocumentDB supports audit logs supports connections ,ddl , authorization and usermanagement , which can be enable through aws console or cli .
AWS DocumentDB profiler supports aggregate , count ,delete , insert , update ,distinct and find query .
Profiler helps to log the execution time and detail of the query performed on DocumentDB.
Profiler logs accessed in the cloud watch logs as well

Create Data Audit Rule - Business rule for collections and database objects , verbs supported
Once the data is in the RDS , and the Data audit rule is defined in the lambda , suspicious query transactions is notified to user ,if found .
Create rules to detect application level threats , which helps todetermine sql injections .
Authorized access will be also present in the rules tables ,which will be matched with the query executed.

Three tables will be created in the RDS - Rules ,Event and Sessions

Rules - contain app/business rules .This table should be pre-populated with business rules , to compare against the transactions metrics .

Event - ID,IP, Hostname, SQL(DML/DDL) ,Time, Rows returned,Connection, Error. Will be captured from the audit and profiler logs .

Session - Application, Hostname, SQL, Start Time , End Time ,DDL/DML ,Error .It will returned information of the particular client session or other attributes .








