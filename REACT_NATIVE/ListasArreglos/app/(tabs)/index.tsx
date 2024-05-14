import React from 'react';
import { View,Text, Button, Alert,TextInput,StyleSheet,FlatList } from 'react-native';
import { useState } from 'react';


let productos = [
  {nombre:'iPhone 13',categoria:'Electrónica',precioCompra:800,precioVenta:1100,id:'A01'},
  {nombre:'Camiseta Adidas',categoria:'Ropa',precioCompra:20,precioVenta:35,id:'B02'},
  {nombre:'Libro ',categoria:'Libros',precioCompra:10,precioVenta:15,id:'C03'},
  {nombre:'Cafe',categoria:'Bebidas',precioCompra:5,precioVenta:8,id:'D04'},
  {nombre:'Reloj',categoria:'Accesorios',precioCompra:30,precioVenta:50,id:'E05'}

]

export default function HomeScreen() {
  return (
    <View style={styles.body}>
      <Text style={{fontWeight:'bold'}}>LISTA DE PRODUCTOS</Text>
      <FlatList
        style={styles.lista}
        data={productos}
        renderItem={(elem)=>{
          return(
            <View style={styles.textoLista}>
              <Text>{elem.item.nombre} ({elem.item.categoria})</Text>
              <Text style={{fontWeight:'bold'}}>USD {elem.item.precioVenta}</Text>
            </View>

          );
        }}

      
      />
    </View>
  );
}

const styles = StyleSheet.create({
    body:{
      backgroundColor:'white',
      flex:1,
      justifyContent:'center',
      alignItems:'center',
      paddingVertical:100
    },
    lista:{
      flex:1,
      margin:20,
      width:250,
    },
    textoLista:{
      borderColor:'deepskyblue',
      borderWidth:1,
      padding:10,
      marginVertical:5,
      borderRadius:15
    },
    negrita:{
      strong:2
    }
});
