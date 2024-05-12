import React from 'react';
import { View,Text, Button, Alert,TextInput,StyleSheet } from 'react-native';
import { useState } from 'react';



export default function App() {
  const [estatura,setEstatura] = useState();
  const [peso,setPeso] = useState();
  const [imc,setImc] = useState(".....................");
  return (
    <View style={styles.body}>
      <Text style={styles.texto}>CALCULADORA DE IMC</Text>
      <Text style={styles.textoSub}>ESTATURA</Text>
      <TextInput
        value={estatura}
        onChangeText={(txt)=>{
          setEstatura(txt);
        }}
        placeholder='Ingresa tu estatura en metros'
        style={styles.cajaText}
      />
      <Text style={styles.textoSub}>PESO</Text>
      <TextInput
        value={peso}
        onChangeText={(txt)=>{
          setPeso(txt);
        }}
        placeholder='Ingresa tu peso en kilogramos'
        style={styles.cajaText}
      />
      <Text></Text>
      <Button
        title='CALCULAR'
        onPress={()=>{
          let est = parseFloat(estatura);
          let ps = parseFloat(peso);
          let imcFor = ps/(est*est);
          setImc(imcFor.toFixed(2));
        }}
      />
      <View style={styles.ct2}>
        <Text style={styles.texto}>RESULTADO:</Text>
        <Text style={styles.texto2}>{imc}</Text>
      </View>

      <View style={styles.ct3}>

        
        <View>
          <Text style={styles.text3}>COMPOSICION CORPORAL</Text>
          <Text style={styles.text4}>Peso inferior al normal</Text>
          <Text style={styles.text4}>Normal</Text>
          <Text style={styles.text4}>Peso superior o normal</Text>
          <Text style={styles.text4}>Obesidad</Text>
          </View>
          <View>
          <Text style={styles.text3}>INDICE DE MASA CORPORAL</Text>
          <Text style={styles.text4}>Menos de 18.5</Text>
          <Text style={styles.text4}>18.5 - 24.9</Text>
          <Text style={styles.text4}>25 - 29.9</Text>
          <Text style={styles.text4}>Mas de 30</Text>
          </View>
        



      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  body:{
    flex:2,
    justifyContent:'center',
    alignItems:'center',
  },
  texto:{
    color:'gold',
    margin:10
  },
  texto2:{
    color:'gold',
    margin:10,
    borderColor:'white',
    borderWidth:2,
    padding:23,
    textAlign:'center'
  },
  textoSub:{
    color:'aqua',
    margin:10
  },
  cajaText:{
    borderColor:'yellow',
    borderWidth:2,
    marginVertical:5,
    backgroundColor:'white',
    padding:3,
    textAlign:'center'
  },
  ct2:{
    flexDirection: 'row',
    justifyContent:'space-between',
    alignItems:'center',
  },

  ct3:{
    backgroundColor:'white',
    borderWidth:3,
    flexDirection:'row'
  },
  text3:{
    color:'crimson',
    margin:2,
    borderColor:'black',
    borderWidth:2,
    padding:5,
    textAlign:'center',
    justifyContent:'space-between',
    alignItems:'center',
    
  },
  text4:{
    color:'black',
    margin:2,
    borderEndColor:'black',
    padding:5,
    textAlign:'center',
    justifyContent:'space-between',
    alignItems:'center'
  }

});
