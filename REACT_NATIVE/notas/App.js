import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import {GradeForm} from './app/screens/GradeForm';
import {ListGrades} from './app/screens/ListGrades';
import { CerrarS } from './app/screens/CerrarSesion';
import "react-native-gesture-handler";
import { createDrawerNavigator } from '@react-navigation/drawer';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs'
import { ContenidoA } from './app/screens/ContenidoA';
import { ContenidoB } from './app/screens/ContenidoB';
import { Icon } from '@rneui/base';

 const Drawer = createDrawerNavigator();
const Tab = createBottomTabNavigator();
export default function App() {
  
  
  const StackGrades = createNativeStackNavigator();
  
  const TabNav=()=>{
    return(
      <Tab.Navigator>
          
          <Tab.Screen 
            name="TabContenidoA"
            component={ContenidoA}
            options={{
                headerShow: false,
                tabBarLabel:'CONFIG',
                tabBarIcon:()=>{
                  return(
                    <Icon  
                    name="app-settings-alt"
                    type="MaterialIcons"
                    color="black"
                  />
                  );
                }
              }}
          >
          </Tab.Screen>

          <Tab.Screen 
            name="TabContenidoB"
            component={ContenidoB}
            options={{
                headerShow: false,
                tabBarLabel:'USUARIO',
                tabBarIcon:()=>{
                  return(
                    <Icon  
                    name="user"
                    type="font-awesome"
                    color="black"
                  />
                  );
                }
              }}
        
          
          >
          </Tab.Screen>          
          
      </Tab.Navigator>
    );
  }
  return (
    <NavigationContainer>
      {/* <StackGrades.Navigator>
        <StackGrades.Screen name='ListNav' component={ListGrades}/>
        <StackGrades.Screen name='GradeNav' component={GradeForm}/>
        
      </StackGrades.Navigator> */}
      <Drawer.Navigator>
      <Drawer.Screen
        name="DrawerListado"
        component={ListGrades}
        options={{
          title:"LISTADO NOTAS"
        }}
      
      >

      </Drawer.Screen>
  

      <Drawer.Screen
        name="DrawerMaterias"
        component={GradeForm}
        options={{
          title:"MATERIAS"
        }}
      
      >

      </Drawer.Screen>

      <Drawer.Screen
        name="Tab"
        component={TabNav}
        options={{
          title:"CONTENIDOS"
        }}
      
      >

      </Drawer.Screen>

      <Drawer.Screen
        name="DrawerFS"
        component={CerrarS}
        options={{
          title:"CERRAR SESION"
        }}
      
      >

      </Drawer.Screen>
    </Drawer.Navigator>
    </NavigationContainer>
    
  );


};


const DrawerNav =()=>{
  return(
    <Drawer.Navigator>
      <Drawer.Screen
        name="DrawerListado"
        component={ListGrades}
        options={{
          title:"LISTADO NOTAS"
        }}
      
      >

      </Drawer.Screen>
  

      <Drawer.Screen
        name="DrawerMaterias"
        component={GradeForm}
        options={{
          title:"MATERIAS"
        }}
      
      >

      </Drawer.Screen>

      <Drawer.Screen
        name="DrawerFS"
        component={GradeForm}
        options={{
          title:"CERRAR SESION"
        }}
      
      >

      </Drawer.Screen>
    </Drawer.Navigator>



  );
}





