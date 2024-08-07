import pandas as pd


# Criando um exemplo de conjunto de dados para detecção de fraudes
data = {
    'transaction_amount': [100, 200, 150, 300, 500, 400, 50, 600, 700, 800, 120, 220, 180, 320, 540, 430, 70, 620, 750, 880],
    'transaction_location': [1, 2, 1, 3, 2, 1, 1, 3, 2, 2, 1, 2, 1, 3, 2, 1, 1, 3, 2, 2],
    'transaction_time': [12, 15, 11, 18, 9, 13, 10, 20, 22, 14, 12, 16, 12, 19, 8, 11, 13, 21, 23, 17],
    'is_fraud': [0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0]
}


# Criando o DataFrame
df = pd.DataFrame(data)


# Salvando o DataFrame em um arquivo CSV
csv_path = 'src/fraud_data.csv'
df.to_csv(csv_path, index=False)


csv_path
