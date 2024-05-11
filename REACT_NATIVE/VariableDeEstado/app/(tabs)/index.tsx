import React from 'react';
import { View,Text, Button, Alert } from 'react-native';
import { useState } from 'react';
export default function App() {
 
  // const arreglo=useState(0);
  // const contadorEstado=arreglo[0];
  // const setContadorEstado = arreglo[1];
  const [contadorEstado,setContadorEstado]=useState(0);
  const incrementar=()=>{
    setContadorEstado(contadorEstado+1);
  }
  const decrementar=()=>{
    setContadorEstado(contadorEstado-1);
  }

//RETO 21

const [vidas,setVidas]=useState(5);

const perderVida=()=>{
  if (vidas==0) {
    Alert.alert('ADVERTENCIA',"GAME OVER")
  }else{
    setVidas(vidas-1);
  }
}
const premiar=()=>{
  setVidas(vidas+3);
}

  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center', backgroundColor:'white'}}>
      {/* <Text>Variables de Estado</Text>
      <Text>Contador Estado: {contadorEstado}</Text>
      <Button
          title='Incrementar'
          onPress={incrementar}
      />
      <Button
          title='Decrementar'
          onPress={decrementar}
      /> */}
      <Text>JUEGO DE VIDAS</Text>
      <Text>VIDAS: {vidas}</Text>
      <Button
          title='PERDER VIDAS'
          onPress={perderVida}
      />
      <Button
          title='PREMIAR'
          onPress={premiar}
      />
    </View>
  );
}