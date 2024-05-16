import { StatusBar } from 'expo-status-bar';
import React, { useState } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { Button } from '@rneui/base';
import { Input } from '@rneui/themed';
import { Alert } from 'react-native';

export default function App() {
  const [name,setName] = useState();
  return (
    <View style={styles.container}>
      <Text>RNE</Text>
      <Button
        icon={{
          name:"home",
          type:'font_awesome',
          size:15,
          color:"#0FF"
        }}

        //Tambien puedes insertar directamente un icono importando la palabra Icon alado del button
        
        title='OK'
        onPress={()=>Alert.alert("Info","Su nombre es "+name)}
      />
      <Input
        value={name}
        onChangeText={setName}
        placeholder='Ingrese su nombre'
        label='Nombre'

      />
      <Text>{name}</Text>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
