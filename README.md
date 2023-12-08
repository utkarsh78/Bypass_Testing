**SOFTWARE TESTING PROJECT : CLIENT SIDE TESTING (BYPASS TESTING)**<br /><br />
Values that violate constraints on the inputs, as defined by client-side information.<br /><br />
Client-side script validation: Programs run on the client to check the syntax of input data before
sending it to the server. Uses explicit attributes associated with HTML form fields. Example, a text
box can be set to only allow strings up to a maximum length.<br /><br />
Bypass testing creates inputs that intentionally violate these validation rules and constraints. Created
inputs are directly submitted to the web application without letting the web page validate them.
<br />

**TOOL USED FOR TESTING:**<br />
**Burp Suite Community Edition:** https://portswigger.net/burp/releases/professional-community-2023-10-3-6?requestededition=community&requestedplatform=
<br /><br />
This involved strategically enabling the intercept feature at specific points within the system where we aimed to assess its resilience.
<br /><br />
By activating the intercept, we were able to pause the communication flow at desired junctures, allowing us
to modify and inspect values before allowing the traffic to proceed.
<br /><br />
This approach provided valuable insights into the system’s behavior and allowed us to identify potential
vulnerabilities by assessing its response to manipulated inputs.
<br />

**SELENIUM**:<br />
In order to conduct thorough client-side testing, we leveraged the Selenium framework, utilizing the
ChromeDriver to automate the web browser for testing purposes. This approach allowed us to simulate user
interactions with the application’s graphical user interface. By programmatically opening browser windows,
we systematically navigated through the application, interacting with various fields and submitting data.
<br /><br />
Our test scenarios were implemented using Java, taking advantage of Selenium’s capabilities to locate web
elements, perform actions such as inputting data into fields, and navigating through different pages. This
comprehensive testing methodology not only verified the correctness of user inputs but also assessed the
application’s responsiveness to diverse user interactions.
<br />

**TEAM MEMBER WISE CONTRIBUTIONS:**
<br />

Customer and Bookings managed by TUSHAR NAGPAL.<br />
Owner and Properties managed by UTKARSH SHRIVASTAVA <br />

**Backend:**
- TUSHAR NAGPAL <br />
 <table>
  <tr>
    <th>API</th>
    <th>API DESCRIPTION</th>
  </tr>
  <tr>
    <td>/api/customers/</td>
    <td>register new customer</td>
  </tr>
  <tr>
    <td>/api/customers/login</td>
    <td>customer login using phone and password</td>
  </tr>
  <tr>
    <td>/api/customers/getCustomer</td>
    <td>returns customer details by taking phone</td>
  </tr>
  <tr>
    <td>/api/bookings/newBooking</td>
    <td>books slot for a customer</td>
  </tr>
  <tr>
    <td>/api/bookings/get</td>
    <td>retrieves bookings by taking vehicle registration number</td>
  </tr>
  <tr>
    <td>/api/bookings/currentBooking</td>
    <td>returns the list of ongoing bookings</td>
  </tr>
  <tr>
    <td>/api/bookings/out</td>
    <td>takes remaining payment and marks the booking as done by filling out-date</td>
  </tr>
  <tr>
    <td>/api/bookings/pastBooking</td>
    <td>returns all past bookings that customer has done</td>
  </tr>
</table> 

- UTKARSH SHRIVASTAVA <br />
 <table>
  <tr>
    <th>API</th>
    <th>API DESCRIPTION</th>
  </tr>
  <tr>
    <td>/api/owner/</td>
    <td>register new owner</td>
  </tr>
  <tr>
    <td>/api/owner/login</td>
    <td>owner login using phone and password</td>
  </tr>
  <tr>
    <td>/api/owner/getOwner/{phone}</td>
    <td>returns owner details by taking phone</td>
  </tr>
  <tr>
    <td>/api/properties/</td>
    <td>registers new property under a particular owner</td>
  </tr>
  <tr>
    <td>/api/properties/update</td>
    <td>modifications in already registered property details</td>
  </tr>
  <tr>
    <td>/api/properties/getPropCust</td>
    <td>returns list of properties in a particular area with pincode given</td>
  </tr>
  <tr>
    <td>/api/properties/getByOwner/{ownerId}</td>
    <td>returns properties registered under a particular owner</td>
  </tr>
  <tr>
    <td>/api/bookings/pastBooking</td>
    <td>returns all past bookings that customer has done</td>
  </tr>
</table> 

**Frontend:**
- **TUSHAR NAGPAL** <br />
 <table>
  <tr>
    <th>MODULE</th>
  </tr>
  <tr>
    <td>Customer.js</td>
  </tr>
  <tr>
    <td>CustomerRegister.js<td>
  </tr>
  <tr>
    <td>Login.js</td>
  </tr>
  <tr>
    <td>History.js</td>
  </tr>
  <tr>
    <td>Bookings.js</td>
  </tr>
  <tr>
    <td>BookingSlot.js</td>
  </tr>
</table> 

- **UTKARSH SHRIVASTAVA** <br />
 <table>
  <tr>
    <th>MODULE</th>
  </tr>
  <tr>
    <td>Owner.js</td>
  </tr>
  <tr>
    <td>Register.js<td>
  </tr>
  <tr>
    <td>OwnerRegister.js</td>
  </tr>
  <tr>
    <td>Dashboard.js</td>
  </tr>
  <tr>
    <td>OwnerProperties.js</td>
  </tr>
  <tr>
    <td>ViewBooking.js</td>
  </tr>
</table> 

**Burp Suite Bypass Testing:**
- **Customer and Bookings** modules are tested by **TUSHAR NAGPAL** <br />
- **Owner and Property** modules are tested by **UTKARSH SHRIVASTAVA** <br />

**Selenium Testing:**
- Invalid and Valid Test cases for **Customer Login and Customer Registration** are generated by **TUSHAR NAGPAL** <br />
- Invalid and Valid Test cases for **Owner Login and Owner Registration** are generated by **UTKARSH SHRIVASTAVA** <br />

--- END OF DOCUMENT --