# Logistic Regression Training Algorithm

## 1. **Initialization**
Initialize the parameters and gradients:

\[
J = 0, \quad dw_1 = 0, \quad dw_2 = 0, \quad db = 0
\]

## 2. **Loop Over Training Examples**
For each training example \( i = 1 \) to \( m \):

### **Forward Propagation**
1. Compute the linear combination:

   \[
   z^{(i)} = w^T x^{(i)} + b
   \]

2. Apply the **sigmoid activation function**:

   \[
   a^{(i)} = \sigma(z^{(i)}) = \frac{1}{1 + e^{-z^{(i)}}}
   \]

3. Compute the **log loss**:

   \[
   J_t = - \left[ y^{(i)} \log a^{(i)} + (1 - y^{(i)}) \log (1 - a^{(i)}) \right]
   \]

### **Compute Gradients (Backpropagation)**
1. Compute the derivative of \( z \):

   \[
   dz^{(i)} = a^{(i)} - y^{(i)}
   \]

2. Compute the gradients of weights:

   \[
   dw_1 \mathrel{+}= x_1^{(i)} dz^{(i)}
   \]

   \[
   dw_2 \mathrel{+}= x_2^{(i)} dz^{(i)}
   \]

3. Compute the gradient of the bias:

   \[
   db \mathrel{+}= dz^{(i)}
   \]

## 3. **Averaging the Gradients**
After iterating over all \( m \) training examples:

\[
J /= m
\]

\[
dw_1 /= m, \quad dw_2 /= m, \quad db /= m
\]

## 4. **Gradient Descent Update**
Update the parameters using the learning rate \( \alpha \):

\[
w_1 := w_1 - \alpha dw_1
\]

\[
w_2 := w_2 - \alpha dw_2
\]

\[
b := b - \alpha db
\]

## **Key Takeaways**
- Logistic regression uses the **sigmoid function** for binary classification.
- **Gradient descent** updates the weights and bias based on the computed gradients.
- The **cost function (log loss)** is averaged over all training examples.
- The **learning rate \( \alpha \)** controls the step size in gradient descent.
