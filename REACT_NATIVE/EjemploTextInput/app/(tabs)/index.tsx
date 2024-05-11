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

const [nombre,setNombre]=useState("Ingrese su nombre");
const [apellido, setApellido]=useState("Ingrese su apellido")
const [nombreCompleto,setNombreCompleto]=useState("");  
return (
    <View style={styles.container}>
      <Text>Ejemplo Text Input</Text>
      <TextInput
        style={styles.cajaTexto}
        value={nombre}
        onChangeText={(txt)=>{
          setNombre(txt);
        }}
      />
      <TextInput
        style={styles.cajaTexto}
        value={apellido}
        onChangeText={(txt)=>{
          setApellido(txt);
        }}
      />
      <Text>
        Hola {nombreCompleto}
      </Text>

      <Button
        title='Saludar'
        onPress={()=>{
            let completo = nombre+" "+apellido;
            setNombreCompleto(completo);
            
        }}

      
      />
      


    </View>
  );
  



}