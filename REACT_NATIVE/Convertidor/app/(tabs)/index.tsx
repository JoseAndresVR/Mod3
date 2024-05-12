import { View,Text, Button, Alert,TextInput,StyleSheet } from 'react-native';
import { useState } from 'react';
export default function App() {
  const [pesoMX,setPesoMX] = useState("Ingresa el valor en dolares");
  const [pesoCL,setPesoCL] = useState("Ingresa el valor en dolares");
  const [euro,setEuro] = useState("Ingresa el valor en dolares");
  const [conversion,setConversion] = useState("Su conversion es: ")
  
  return (
    <View style={styles.container}>
         <Text style={styles.Texto}>CONVERTIDOR DE DOLARES A PESOS MX</Text>
        <TextInput
          style={styles.cajaTexto}
          value={pesoMX}
          onChangeText={(txt)=>{
            setPesoMX(txt);
          }}
        />
        <Button
            title='Convertir a MX'
            onPress={()=>{
              let pesoM = parseFloat(pesoMX);
              let pesoMXC = pesoM*16.78;
              setConversion("Su conversion es: "+pesoMXC+" pesos mexicanos")
            }}
        />

<Text style={styles.Texto}>CONVERTIDOR DE DOLARES A PESOS CLB</Text>
        <TextInput
          style={styles.cajaTexto}
          value={pesoCL}
          onChangeText={(txt)=>{
            setPesoCL(txt);
          }}
        />
        <Button
          title='Convertir a CL'
          onPress={()=>{
            let pesoC = parseFloat(pesoCL);
            let pesoCLM = pesoC*3886.64;
            setConversion("Su conversion es: "+pesoCLM+" pesos colombianos")
          }}
        />

        <Text style={styles.Texto}>CONVERTIDOR DE DOLARES A EUROS</Text>
        <TextInput
          style={styles.cajaTexto}
          value={euro}
          onChangeText={(txt)=>{
            setEuro(txt);
          }}
        />
        <Button
          title='Convertir a EU'
          onPress={()=>{
            let eur = parseFloat(euro);
            let euros = eur*0.93;
            setConversion("Su conversion es: "+euros+" euros")
          }}
        />

        <Text style={styles.Texto}>RESULTADO DE CONVERSION</Text>
        <Text style={styles.Texto}>{conversion}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container:{
    flex: 1, 
    justifyContent: 'center', 
    alignItems: 'center', 
    backgroundColor:'white',
    margin:10
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