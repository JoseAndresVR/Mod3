import React from 'react';
import { View,Text, Button, Alert,TextInput,StyleSheet } from 'react-native';
import { useState } from 'react';

export default function App() {
  const [numero1,setNumero1] = useState("Ingresa el valor 1");
  const [numero2,setNumero2] = useState("Ingresa el valor 2");
  const [resultado,setResultado] = useState("Resultado: ");
  return (
    <View style={styles.container}> 
        <Text>Calculadora</Text>
        <TextInput
          style={styles.cajaTexto}
          value={numero1}
          onChangeText={(txt)=>{
            setNumero1(txt);
          }}
        />
        <TextInput
          style={styles.cajaTexto}
          value={numero2}
          onChangeText={(txt)=>{
            setNumero2(txt);
          }}
        />
        <Text style={styles.Texto}>
          {resultado}
        </Text>
        <Button
          
          title='Sumar'
          onPress={()=>{
            let num1=parseInt(numero1);
            let num2=parseInt(numero2);
            let suma = num1+num2;
            setResultado("Resultado: "+suma);
          }}
          
        />
        
    </View>
  );
}

const styles = StyleSheet.create({
  container:{
    flex: 1, 
    justifyContent: 'center', 
    alignItems: 'center', 
    backgroundColor:'white'
  },
  cajaTexto:{
    borderColor:'black',
    borderWidth:1,
    padding:5,
    marginVertical:10
  },
  Texto:{
    marginVertical:10
  }
});
