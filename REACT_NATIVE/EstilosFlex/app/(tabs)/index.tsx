import React from 'react';
import { View, Button,StyleSheet,Text } from 'react-native';



export default function App() {
  return (
    <View style={styles.container}>
      <View style={styles.cj1}>
        <Button title='X'/>
        <Button title='Y'/>
        <Button title='Z'/>
      </View>
      <View style={styles.cj2}>
        <View style={styles.cj4}>
          <View style={styles.cj6}>
            <Button title='Boton 1'/>
            <Button title='Boton 2'/>
          </View>
          <View style={styles.cj7}>
            <Button title='OPERACION 1'/>
            <Button title='OPERACION 2'/>
            <Button title='OPERACION 3'/>
          </View>
        </View>
        <View style={styles.cj5}>
          <Button title='ACCION 1'/>
          <Button title='ACCION 2'/>
        </View>
      </View>
      <View style={styles.cj3}>
        <Button title='BOTON FINAL'/>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container:{
    backgroundColor:'green',
    flexDirection: 'column',
    flex:1
  },
  cj1:{
    backgroundColor:'purple',
    flex:1,
    flexDirection:'row',
    justifyContent:'flex-end',
    alignItems:'center'
  },
  cj2:{
    backgroundColor:'white',
    flex:6
  },
  cj3:{
    backgroundColor:'gray',
    flex:1,
    justifyContent:'center',
    alignItems:'flex-start'
  },
  cj4:{
    backgroundColor:'orange',
    flex:4,
    flexDirection:'row'
  },
  cj5:{
    backgroundColor:'blue',
    flex:1,
    flexDirection:'row',
    justifyContent:'center',
    alignItems:'flex-end'
  },
  cj6:{
    backgroundColor:'yellow',
    flex:2,
    justifyContent:'center',
    
  },
  cj7:{
    backgroundColor:'black',
    flex:2,
    justifyContent:'center',
    alignItems:'flex-start'
  },

  
});
