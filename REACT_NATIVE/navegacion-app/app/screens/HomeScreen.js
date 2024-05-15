import {View,Text,StyleSheet, Button} from 'react-native'

export const Home=({navigation})=>{
   return(
   <View style={styles.bdys}>
        <Text>HOME</Text>
        <View style={{flexDirection:'row',marginVertical:10}}>
        <View style={{marginHorizontal:5}}>
        <Button
            title='Ir a Contactos'
            onPress={()=>{
                navigation.navigate('ContactsNav');
            }}
        />
        </View>
        <View style={{marginHorizontal:5}}>
        <Button
            title='Ir a Productos'
            onPress={()=>{
                navigation.navigate('ProductosNav');
            }}

        />
        </View>
        </View>
   </View>
   );
}

const styles = StyleSheet.create({
    bdys:{
        flex:1,
        backgroundColor:'white',
        justifyContent:'center',
        alignItems:'center'
    }
});