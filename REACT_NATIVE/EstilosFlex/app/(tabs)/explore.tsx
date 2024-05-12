
import { View, Button,StyleSheet } from 'react-native';

export default function TabTwoScreen() {
  return (
    <View style={styles.containerPrincipal}>
      
    </View>
  );
}

const styles = StyleSheet.create({
  containerPrincipal:{
    backgroundColor:'white',
  },
  cj1:{
    backgroundColor:'blue',
    flex:1,
    flexDirection:'row',
    justifyContent:'center'
  },
  cj2:{
    backgroundColor:'white',
    flex:6
  },
  cj3:{
    backgroundColor:'green',
    flex:1
  },
  cj4:{
    backgroundColor:'orange',
    flex:4,
    flexDirection:'row'
  },
  cj5:{
    backgroundColor:'blue',
    flex:1
  },
  cj6:{
    backgroundColor:'yellow',
    flex:2
  },
  cj7:{
    backgroundColor:'black',
    flex:2
  },

  
});
