import joblib
import pandas as pd
import numpy as np

def getModelPrediction(towers, players):
    modelo = joblib.load('C:/Users/luisl/Documents/javaPythonInterpreter/src/main/resources/python/random-forest.joblib')
    data={'towers':[towers],'players':[players]}
    df2=pd.DataFrame(data)
    predicciones = np.array_str(modelo.predict(X = df2))
    return predicciones