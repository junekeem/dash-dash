# Delivery Application API Development Guide

## Goal

This guide outlines essential requirements and considerations for developing the API of a delivery application.

## 1. Feature Specification

- Order creation, retrieval, status updates, and deletion
- Restaurant list retrieval / Restaurant retrieval, addition, modification, and deletion
- Menu retrieval, addition, modification, and deletion
- User register, login, retrieve, update, and deletion, User-specific order history access
- Payment creation, retrieval of payment information, and payment cancellation and refund

## 2. Endpoint Design

### 2.1. Order Management

- `/api/orders`: Endpoints related to orders
    - `POST /api/orders`: Order creation (all user roles; authentication required)
    - `GET /api/orders/{orderId}`: Retrieve a specific order
        - Regular users: Can only retrieve their own orders
        - Restaurant owners: Can retrieve orders from their own restaurant
        - App administrators: Can retrieve all orders
    - `PUT /api/orders/{orderId}`: Update order status
        - Regular users: Can only update their own orders
        - Restaurant owners: Can update orders from their own restaurant
        - App administrators: Can update all orders
    - `DELETE /api/orders/{orderId}`: Delete an order
        - Regular users: Can only delete their own orders
        - Restaurant owners: Can delete orders from their own restaurant
        - App administrators: Can delete any order

### 2.2. Restaurant Management

- `/api/restaurants`: Endpoints related to restaurants
    - `GET /api/restaurants`: Retrieve a list of restaurants (all user roles, public)
    - `POST /api/restaurants`: Add a restaurant
        - App administrators only
    - `GET /api/restaurants/{restaurantId}`: Retrieve a specific restaurant (all user roles, public)
    - `PUT /api/restaurants/{restaurantId}`: Modify a restaurant
        - Restaurant owners and app administrators only
    - `DELETE /api/restaurants/{restaurantId}`: Delete a restaurant
        - App administrators only
    - `GET /api/restaurants/{restaurantId}/menus`: Retrieve the menus of a specific restaurant (all user roles, public)

### 2.3. Menu Management

- `/api/menus`: Endpoints related to menus
    - `POST /api/menus`: Add a menu to a specific restaurant
        - Restaurant owners: Can add menus from their own restaurant
        - App administrators: Can add any menus to any restaurants
    - `GET /api/menus/{menuId}`: Retrieve a specific menu (all user roles, public)
    - `PUT /api/menus/{menuId}`: Modify a menu
        - Restaurant owners and app administrators only
    - `DELETE /api/menus/{menuId}`: Delete a specific menu
        - Restaurant owners: Can delete menus from their own restaurant
        - App administrators: Can delete any menus to any restaurants

### 2.4. User Management

- `/api/users`: Endpoints related to users
    - `GET /api/users`: Retrieve a list of users
        - App administrators only
    - `POST /api/users/signup`: Register a new user (public)
    - `POST /api/users/login`: User login (public)
    - `GET /api/users/{userId}`: Retrieve user profiles (authentication required)
        - Regular users and restaurant owners: Can only retrieve their own profile
        - App administrators: Can retrieve any user's profile
    - `PUT /api/users/{userId}`: Update user profiles
        - Regular users and restaurant owners: Can only update their own profile
        - App administrators: Can update any user's profile
    - `DELETE /api/users/{userId}`: Delete a user
        - App administrators only
    - `GET /api/users/{userId}/orders`: Retrieve specific user's order history
        - Regular users and restaurant owners: Can only retrieve their own order history
        - App administrators: Can retrieve any user's order history

### 2.4. Payment System

- `/api/payments`: Endpoints related to payments
    - `POST /api/payments`: Payment creation (all user roles)
    - `GET /api/payments/{paymentId}`: Get specific payment information
    - `PUT /api/payments/{paymentId}/refund`: Cancel and refund a payment

### 2.5. Review and Rating System
- `/api/reviews`: Endpoints related to reviews
    - `POST /api/reviews`: Review creation (all user roles)
    - `GET /api/reviews/{reviewId}`: Get specific review information
    - `PUT /api/reviews/{reviewId}`: Update specific review information

## 3. Data Models

### Order

- `orderId`
- `userId`
- `restaurantId`
- `menus`
- `totalAmount`
- `status` (Order status: Pending, Processing, Completed, etc.)

<details>
    <summary>Order Table</summary>
    <pre>
+-------------------+
|       Order       |
+-------------------+
| order_id          | PRIMARY KEY
| user_id           | FOREIGN KEY -> User(user_id)
| restaurant_id     | FOREIGN KEY -> Restaurant(restaurant_id)
| menus             | JSON
| total_amount      | DECIMAL(10, 2) NOT NULL
| status            | VARCHAR(20) NOT NULL
| created_at        | TIMESTAMP DEFAULT CURRENT_TIMESTAMP
| updated_at        | TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
+-------------------+
</pre>
</details>

### Restaurant

- `restaurantId`
- `name`
- `ownerId`
- `address`
- `phone`
- `menus`

<details>
    <summary>Restaurant Table</summary>
    <pre>
+-------------------+
|    Restaurant    |
+-------------------+
| restaurant_id    | PRIMARY KEY
| name             | VARCHAR(255) NOT NULL
| owner_id         | VARCHAR(255) NOT NULL
| address          | VARCHAR(255) NOT NULL
| phone            | VARCHAR(15) NOT NULL
| created_at       | TIMESTAMP DEFAULT CURRENT_TIMESTAMP
| updated_at       | TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
+-------------------+
</pre>
</details>

### Menu

- `menuId`
- `restaurantId`
- `name`
- `price`
- `options`
- `image`

<details>
    <summary>Menu Table</summary>
    <pre>
+-------------------+
|       Menu        |
+-------------------+
| menu_id           | PRIMARY KEY
| restaurant_id     | FOREIGN KEY -> Restaurant(restaurant_id)
| name              | VARCHAR(255) NOT NULL
| price             | DECIMAL(10, 2) NOT NULL
| options           | JSON
| image             | BLOB
| created_at        | TIMESTAMP DEFAULT CURRENT_TIMESTAMP
| updated_at        | TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
+-------------------+
</pre>
</details>

### User

- `userId`
- `username`
- `email`
- `password`
- `address`
- `role` (User roles: Regular user, Restaurant owner, App administrator)
- `ownedRestaurants` (Only for restaurant owners)

<details>
    <summary>User Table</summary>
    <pre>
+-------------------+
|        User       |
+-------------------+
| user_id           | PRIMARY KEY
| username          | VARCHAR(255) NOT NULL
| email             | VARCHAR(255) NOT NULL
| password          | VARCHAR(255) NOT NULL
| address           | VARCHAR(255)
| role              | VARCHAR(20) NOT NULL
| owned_restaurants | JSON
| created_at        | TIMESTAMP DEFAULT CURRENT_TIMESTAMP
| updated_at        | TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
+-------------------+
</pre>
</details>

### Payment

- `paymentId`
- `orderId`
- `userId`
- `amount`
- `status` (Payment status: Pending, Success, Failure, etc.)
- `refundAmount`

<details>
    <summary>Payment Table</summary>
    <pre>
+-------------------+
|      Payment      |
+-------------------+
| payment_id        | PRIMARY KEY
| order_id          | FOREIGN KEY -> Order(order_id)
| user_id           | FOREIGN KEY -> User(user_id)
| amount            | DECIMAL(10, 2) NOT NULL
| status            | VARCHAR(20) NOT NULL
| refund_amount     | DECIMAL(10, 2)
| created_at        | TIMESTAMP DEFAULT CURRENT_TIMESTAMP
| updated_at        | TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
+-------------------+
</pre>
</details>


### Review

- `reviewId`
- `orderId`
- `rating`
- `comment`
- `image`

<details>
    <summary>Review Table</summary>
    <pre>
+-------------------+
|      Review      |
+-------------------+
| review_id         | PRIMARY KEY
| order_id          | FOREIGN KEY -> Order(order_id)
| rating            | DECIMAL(2, 2)
| comment           | TEXT
| image             | BLOB
| created_at        | TIMESTAMP DEFAULT CURRENT_TIMESTAMP
| updated_at        | TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
+-------------------+
</pre>
</details>

## 4. Security

- User authentication and authorization (JWT, etc.)
- Access control using API keys or tokens

## 5. Exception Handling

- Return appropriate HTTP status codes
- Send user-friendly error messages

## 6. Documentation

- Document API endpoints and request/response formats (Swagger or OpenAPI)
- Include example requests and responses

## 7. Testing

- Write unit tests and integration tests
- Set up a test environment using mock data
