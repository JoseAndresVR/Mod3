import React from 'react';
import { View,Text, Button, Alert,TextInput,StyleSheet } from 'react-native';
import { useState } from 'react';
export default function App() {
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
});
  
  
  return (
    <View style={styles.container}>
      <Text>Ejemplo Text Input</Text>
      <TextInput
        style={styles.cajaTexto}
        value='Ingrese un valor'
        onChangeText={}
      />


    </View>
  );
  



}