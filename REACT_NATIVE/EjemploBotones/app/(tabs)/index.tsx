import React from 'react';
import { View,Text, Button, Alert } from 'react-native';

export default function App() {
  finalizar=()=>{
    Alert.alert("Su sesion ha finalizado");
  }
  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center', backgroundColor:'white'}}>
      <Text>
          Hola
      </Text>
    <Button
      title= "FINALIZAR"
      onPress={finalizar}
      
      />
    <Button
      title= "INICIAR"
      onPress={
        ()=>{
          Alert.alert("Su sesion ha iniciado");
        }
      }
      />

    </View>
  );
}

