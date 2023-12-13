## ClientController Methods

### Additional Features

#### Client Charts by State
- **Description:** The project includes charts representing clients categorized by states.

#### Active and Non-Active Clients in the Last 6 Months
- **Description:** The project includes charts representing active clients (those who placed orders in the last 6 months) and non-active clients (those who haven't placed orders in the last 6 months).

### Note: Angular Sorting and Searching
For client-side sorting and searching, implement the following methods in your Angular application:

#### Sort Clients by Name
- **Method:** Angular Sorting Implementation
- **Description:** Implement sorting functionality for clients by name on the Angular side.

#### Search Clients by Address
- **Method:** Angular Searching Implementation
- **Description:** Implement searching functionality for clients by Address on the Angular side.

#### Search Clients by Name
- **Method:** Angular Searching Implementation
- **Description:** Implement searching functionality for clients by name on the Angular side.

### 1. Get Most Loyal Client
- **Endpoint:** `/api/clients/most-loyal`
- **Description:** Retrieves the most loyal client.
- **HTTP Method:** GET
- **Response:** Returns the most loyal client or a 404 if none found.

### 2. Get Non-Active Clients
- **Endpoint:** `/api/clients/non-active-clients`
- **Description:** Retrieves a list of non-active clients.
- **HTTP Method:** GET
- **Response:** Returns the list of non-active clients.

### 3. Get Active Clients
- **Endpoint:** `/api/clients/active-clients`
- **Description:** Retrieves a list of active clients.
- **HTTP Method:** GET
- **Response:** Returns the list of active clients or a 404 if none found.

### 4. Get All Clients
- **Endpoint:** `/api/clients/all`
- **Description:** Retrieves a list of all clients.
- **HTTP Method:** GET
- **Response:** Returns the list of all clients.

### 5. Get Clients by Number of Invoices
- **Endpoint:** `/api/clients/by-nb-factures`
- **Description:** Retrieves clients sorted by the number of invoices.
- **HTTP Method:** GET
- **Response:** Returns the list of clients sorted by the number of invoices.

### 6. Get Client Counts by Address
- **Endpoint:** `/api/clients/client-counts-by-address`
- **Description:** Retrieves a map of client counts grouped by address.
- **HTTP Method:** GET
- **Response:** Returns the map of client counts by address.

### 7. Get Invoice Counts by Client (Ordered Descending)
- **Endpoint:** `/api/clients/invoice-counts-ordered-descending`
- **Description:** Retrieves a map of invoice counts by client, ordered in descending order.
- **HTTP Method:** GET
- **Response:** Returns the map of invoice counts ordered in descending order.

### 8. Get Count of Active Clients
- **Endpoint:** `/api/clients/active-clients-count`
- **Description:** Retrieves the count of active clients.
- **HTTP Method:** GET
- **Response:** Returns the count of active clients.

### 9. Get Count of Non-Active Clients
- **Endpoint:** `/api/clients/non-active-clients-count`
- **Description:** Retrieves the count of non-active clients.
- **HTTP Method:** GET
- **Response:** Returns the count of non-active clients.

### 10. Get Count of All Clients
- **Endpoint:** `/api/clients/all-client-count`
- **Description:** Retrieves the count of all clients.
- **HTTP Method:** GET
- **Response:** Returns the count of all clients.
