import {View,Text,StyleSheet, Button} from 'react-native'

export const Contacts=({navigation})=>{
   return(
   <View style={style.bdy}>
        <Text>Estoy en contactos</Text>
        <Button
            title='Ir a HOME'
            onPress={()=>{
                navigation.navigate('HomeNav');
            }}

        />
   </View>
   );
}

const style = StyleSheet.create({
    bdy:{
        flex:1,
        backgroundColor:'white',
        justifyContent:'center',
        alignItems:'center'
    }
});