\# UPL Tutorial Management System Architecture



\## Application Architecture



Client

&#x20;|

&#x20;↓

REST API

&#x20;|

&#x20;↓

Controller Layer

&#x20;|

&#x20;↓

Service Layer

&#x20;|

&#x20;↓

Repository Layer

&#x20;|

&#x20;↓

MySQL Database





\## Security Architecture



User Login

&#x20;|

&#x20;↓

JWT Token Generation

&#x20;|

&#x20;↓

JWT Authentication Filter

&#x20;|

&#x20;↓

Role Based Authorization

&#x20;|

&#x20;↓

Protected API Access





\## User Roles



ADMIN:

\- Manage users

\- Approve instructors

\- Manage courses



INSTRUCTOR:

\- Create courses

\- Create tutorials



STUDENT:

\- Enroll courses

\- Complete tutorials

\- Track progress

