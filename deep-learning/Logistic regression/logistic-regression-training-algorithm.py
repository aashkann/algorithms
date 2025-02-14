import numpy as np

# Sigmoid function
def sigmoid(z):
    return 1 / (1 + np.exp(-z))

# Compute cost function (log loss)
def compute_cost(y, a):
    m = y.shape[0]
    cost = -np.sum(y * np.log(a) + (1 - y) * np.log(1 - a)) / m
    return cost

# Logistic regression training function
def logistic_regression(X, y, learning_rate=0.01, epochs=1000):
    m, n = X.shape  # m = number of samples, n = number of features
    
    # Initialize weights and bias
    w = np.zeros((n, 1))
    b = 0
    
    cost_history = []
    
    for epoch in range(epochs):
        # Forward propagation
        z = np.dot(X, w) + b
        a = sigmoid(z)
        
        # Compute gradients
        dz = a - y
        dw = np.dot(X.T, dz) / m
        db = np.sum(dz) / m
        
        # Update weights and bias
        w -= learning_rate * dw
        b -= learning_rate * db
        
        # Compute and store cost for monitoring
        if epoch % 100 == 0:
            cost = compute_cost(y, a)
            cost_history.append(cost)
            print(f"Epoch {epoch}: Cost = {cost:.4f}")
    
    return w, b, cost_history

# Generate synthetic dataset
np.random.seed(42)
m = 100  # Number of samples
X = np.random.randn(m, 2)  # Two features
true_w = np.array([[2], [-3]])  # True weights
true_b = 1

# Generate labels
z_true = np.dot(X, true_w) + true_b
y = (sigmoid(z_true) > 0.5).astype(int)  # Convert to 0 or 1

y = y.reshape(-1, 1)  # Reshape to column vector

# Train logistic regression model
learning_rate = 0.1
epochs = 1000
w_trained, b_trained, cost_history = logistic_regression(X, y, learning_rate, epochs)

print("Trained weights:", w_trained)
print("Trained bias:", b_trained)
