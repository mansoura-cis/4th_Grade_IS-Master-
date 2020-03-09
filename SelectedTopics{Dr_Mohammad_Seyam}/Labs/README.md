# In The Name Of Allah 

## Task 1.7:

## Key Information (SRS):

- Almost any employee at the company can initiate a purchase
request by filling in a form.
    - Actors => Employee 
    - Proces => procure-to-pay or application-to-approval

- The purchase request includes information about the goods to be purchased, the quantity, the desired delivery date, and the approximate cost.
    - Data => Purchase-Request:{Quantity, delivery date, aproximate cost }

- The employee can nominate a specific vendor.
    - Actor => Vendor
    - process => Nomination

- Employees often request quotes from vendors in order to get the required information.
    - process => Requeste quotes

- Completing the entire form can take a few days as the employee often does not have the required data. 
    - ISSUE => Time-Complixity of getting required data

- The quote is attached to the purchase request.
    - process => Attaching 

- This completed request is signed by two supervisors.
    - Actor => Supervisor
    - process => Signing

    - One supervisor has to provide a financial approval, while the other supervisor has to approve the necessity of the purchase and its conformance with the company’s policy (e.g., if purchasing a software tool, is it compatible with the company’s standard IT operating environment?).
         - Sign1 => Financial
         - Sign2 => Necessity
- Collecting the signatures from the two supervisors takes on average 5 days.
    - ISSUE => Time Complexity

- If it is urgent, the employee can hand-deliver the form,
otherwise it is circulated via internal mail.
    - Exception => Urgent Purchase

- A rejected purchase request is returned to the employee. Sometimes, the employee makes minor modifications and resubmits the purchase request.

- Once a purchase request is approved, it is returned to the initiator
of the request. 

- The employee forwards the form to the purchasing department. Employees often make a copy of the form for their own record, in case the form gets lost. 
    - Actor => purchasing department

- The purchasing department checks the completeness of the purchase request and returns it to the employee if it is incomplete.
    - process => Checking

- The purchasing department then enters the approved request into
the company’s enterprise system.
    - Process => Entery of approved request

- If the employee has not nominated any vendors, a clerk at the Purchasing Department selects one based on the quotes attached to the purchase
requisition, or based on the list of vendors (also called master
vendor list) available in the company’s enterprise system.
    - ISSUE Solving process => Nomination

- Sometimes, the quote attached to the request ha expired in the
meantime. In this case, an updated quote is requested from the
corresponding vendor. Other times, the vendor who submitted the
quote is not recorded in the company’s enterprise system.
    - ISSUE => Expiration solving

- In this case, the purchasing department should give preference
to other vendors who are registered in the enterprise system.
    - ISSUE Solving
- If no such vendors are available or if the registered vendors offer
higher prices than the one in the submitted quote, the
purchasing department can add the new vendor into the
enterprise system.
    - ISSUE Solving

- When a vendor is selected, the enterprise system automatically
generates a purchase order.
    - Process => Automated 

- The purchase order is sent to the vendor by fax. A copy of the purchase order is sent to the accounts payable office. This office, part of the financial department, uses an accounting system that is not integrated
with the enterprise system, where purchase orders are stored.
    - Actor => Financial Department.
    - Process => Storing the order into accounting system
    - ISSUE : Accounting system no integrated

- The goods are always delivered to the goods receipt department.
    - Actor => receipt department.
    - process => Reciept Goods

- When goods are received, a clerk at this department selects the
corresponding purchase order in the enterprise system.

- The clerk checks the quantity and quality, and generates a
document called goods receipt form from the purchase order
stored in the enterprise system. 
    - Process => Checking , Creating goods receipt form.

- The goods are forwarded to the employee who initiated the purchase requisition.  A print-out of the goods receipt form is sent to the accounts payable office. If there are any issues with the goods, they are returned to the vendor and a note is sent to the purchasing department and to
the accounts payable office for archival.
    - Process => Reciept
    - ISSUE => Goods
    - Solve => Resturn to Vendor

- The vendor eventually sends the invoice directly to the accounts
payable office. A clerk at this office compares the purchase order,
the goods receipt and the invoice.
    - Process => Sending Bill

- This latter task is called threeway matching. Three-way matching is time-consuming because the clerk needs to carefully investigate each discrepancy. 
    - Process => Three-way matching
    - ISSUE => Time Consuming


- The payment process takes so long that the company often misses the
deadline for invoice payment and has to pay a penalty.

- At the end, the clerk triggers the bank transfer and sends a
payment notice to the vendor. Some vendors explicitly indicate in
their invoice the bank account number to which the transfer
should be made. It happens that the bank account number and
name indicated in the invoice differ from the one recorded in the
vendor database. Sometimes payments bounce back, in which case
the vendor is contacted by phone, email or postal mail.
    - process => Payment
    - ISSUE => Bounce Back
    - Solve => Vendor contact

- If new bank details are given, the transfer is attempted again. If
the issue is still not resolved, the accounts payable office has to
contact again the vendor in order to trace the cause of the
bounced payment.
    - Actor => Bank
    - ISSUE => Not solved bouncing

---
### Questions

- What type of process is the above one: order-to-cash,
procure-to-pay, application-to- approval, or issue-toresolution?
    - procure-to-pay

- Who are the actors in this process?
    - Employees
        - receipt department.
        - Finacial department.
        - Supervisors
        - Purchasing Employee
    - Vendors 
    - Bank

- Who are the customers?
    - Vendor
- What are the tasks of this process?
    - Every process Audited
- What value does the process deliver to its customers?
    - Purchase their goods
- What are the possible outcomes of this process?
    - Bouncing the invoice
    - reject payment
    - Successful payment

- Taking the perspective of the customer, what performance
measures can be attached to this process?
    - The Speed of payment proecess in every level

- What potential issues do you foresee this process might have?
    - Time-Complexity of collecting requirements
    - Time Complexity of Review and Checking
    - Bouncing payment
    -  integration of systems

- What information would you need to collect in order to analyze
these issues?
    - Banking Audits
    - The colids of how to collect required data
    - expirations 
- What possible changes do you think could be made to this
process in order to address the above issues?
    - more automation in payment process and accounting 
    - application to simply specify the required data and its validations

