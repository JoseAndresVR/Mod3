import React from 'react';
import { View,Text, Button, Alert,TextInput,StyleSheet,FlatList,ScrollView } from 'react-native';
import { useState } from 'react';
let productos = [
  {nombre:'iPhone 13',categoria:'Electrónica',precioCompra:800,precioVenta:960,id:'01'},
  {nombre:'Camiseta Adidas',categoria:'Ropa',precioCompra:20,precioVenta:24,id:'02'}

];
let esNuevo=true;
let indiceSel=-1;
export default function App() {
  
  const [codigoU,setCodigo] = useState();
  const [nombreU,setNombre] = useState();
  const [categoriaU,setCategoria] = useState();
  const [precioC,setPrecioC] = useState();
  const [precioV,setPrecioV] = useState();
  const [nProductos,setNproductos] = useState(productos.length);
  
  let calcularPrecioVenta = (precioCompra) => {
    if (precioCompra=="") {
      setPrecioV("")
    }else{
      let prc = parseInt(precioCompra);
      let calculo = prc+(prc*0.2)
      setPrecioV(calculo.toFixed(2))
    }
  };

  let existePersona=()=>{
    for(let i=0;i<productos.length;i++){
      if (productos[i].id==codigoU) {
        return true
      }
    }
    return false 
  }

  let guardarProducto=()=>{
    console.log(esNuevo);

    if (esNuevo) {
      if (existePersona()) {
        Alert.alert("INFO","EL PRODUCTO CON EL ID INGRESADO YA EXISTE")
      }else{
        let prod = {nombre:nombreU,categoria:categoriaU,precioCompra:precioC,precioVenta:precioV,id:codigoU}
        productos.push(prod);
        limpiar();
      }
    }else{
      productos[indiceSel].nombre=nombreU;
      productos[indiceSel].categoria=categoriaU;
      productos[indiceSel].precioCompra=precioC;
      productos[indiceSel].precioVenta=precioV;
      limpiar();
    }
    
  }

  let limpiar=()=>{
    setCodigo(undefined);
    setCategoria(undefined);
    setNombre(undefined);
    setPrecioV(undefined);
    esNuevo=true
  }

  let Medio=(props)=>{
    return (
    <View style={styles.textoLista}>
    
                    <View style={{flexDirection:'row',justifyContent:'space-between',alignItems:'center'}}>
                      <Text style={{marginRight:14}}>{props.indice}</Text>
                      <View>
                        <Text >{props.productos.nombre}</Text>
                        <Text style={{fontSize:10}}>{props.productos.categoria}</Text>
                      </View>
                    </View>
            
                    
                  <View style={{flexDirection:'row',alignItems:'center'}}>
                    <Text style={{fontWeight:'bold',marginRight:15}}>$ {props.productos.precioVenta}</Text>
                    <View style={{margin:3}}>
                      <Button
                        title=' E '
                        onPress={()=>{
                          setCodigo(props.productos.id)
                          setCategoria(props.productos.categoria);
                          setNombre(props.productos.nombre);
                          setPrecioC(props.productos.precioCompra);
                          calcularPrecioVenta(props.productos.precioCompra);
                          esNuevo=false;
                          indiceSel=props.indice
                          
                        }}
                      />
                    </View>
                    <View style={{margin:3}}>
                      
                      <Button
                         title=' X '
                         onPress={()=>{
                          indiceSel=props.indice
                          productos.splice(indiceSel,1);
                          setNproductos(productos.length);
                         }}
                      />
                    </View>
                  </View>
                </View>
    
    );
    };

  return (
  


    <View style={styles.body}>
    <ScrollView style={{marginVertical:80,flex:1}}>
         {/* SUPERIOR */}
      <View style={styles.sup}>
        <Text style={{fontWeight:'bold',textAlign:'center',marginBottom:20,fontSize:25}}>PRODUCTOS</Text>
        <TextInput
          style={styles.formu}
          placeholder='CODIGO'
          value={codigoU}
          onChangeText={(txt)=>{
            setCodigo(txt)
          }}
          keyboardType='number-pad'
          editable={esNuevo}
        />
        <TextInput
          style={styles.formu}
          placeholder='NOMBRE'
          value={nombreU}
          onChangeText={(txt)=>{
            setNombre(txt)
          }}
        />
        <TextInput
          style={styles.formu}
          placeholder='CATEGORIA'
          value={categoriaU}
          onChangeText={(txt)=>{
            setCategoria(txt)
          }}
        />
        <TextInput
          style={styles.formu}
          placeholder='PRECIO DE COMPRA'
          onChangeText={(txt)=>{
            setPrecioC(txt)
            calcularPrecioVenta(txt);
          }}
          keyboardType='number-pad'
        />
        <TextInput
          style={styles.formu}
          placeholder='PRECIO DE VENTA'
          value={precioV}
          editable={false}
          keyboardType='number-pad'
        />
        <View style={styles.btP}>
            <Button
             title='NUEVO'
             onPress={()=>{
              limpiar();
             }}
           />
          
           <Button
              title='GUARDAR'
              onPress={()=>{
                if(nombreU==null && codigoU==null && categoriaU==null && precioC==null && precioV==null){
                  
                  Alert.alert("INFO","TIENES QUE RELLENAR TODOS LOS CAMPOS")
                  console.log(productos)
                  
                }else{
                  guardarProducto();
                  console.log(productos);
                }
                setNproductos(productos.length);
              }}
            />
          <Text>
            Productos: {nProductos}
          </Text>
        </View>
      </View>
     </ScrollView>
     

    {/* MEDIO */}

    <View style={styles.med}>
      <FlatList
          style={styles.lista}
          data={productos}
          renderItem={(elem)=>{
            return(
              <Medio indice={elem.index} productos={elem.item}/>
            );
          }}
          keyExtractor={(item)=>{
            return item.id
          }}
          
          />
      </View>
    
    {/* PARTE FINAL */}
      
    <View style={styles.baj}>

        <Text style={{fontWeight:'bold'}}>CREADO POR JOSÉ ANDRÉS VALENCIA REYES</Text>
    </View>



  </View>

  );
}

const styles = StyleSheet.create({
  body:{
    backgroundColor:'white',
    flex:1,
    alignItems:'center',
    justifyContent:'center',
  },
  lista:{
    width:300,
    marginTop:-50
  },
  textoLista:{
    borderColor:'deepskyblue',
    borderWidth:1,
    padding:10,
    marginVertical:5,
    borderRadius:10,
    flexDirection:'row',
    justifyContent:'space-between',
    
  },
  sup:{
    flex:2,
    justifyContent:'center',
  },
  med:{
    flex:1,
  },
  baj:{
    flex:.15,
    alignItems:'flex-end'
  },
  btP:{
    flexDirection:'row',
    justifyContent:'space-around',
    margin:10,
    alignItems:'center',
  },
  formu:{
    
      borderColor:'slategray',
      borderWidth:1,
      padding:10,
      marginVertical:5,
      borderRadius:15,
      width:350,
    
  }
});
