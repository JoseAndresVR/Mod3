import { StyleSheet, Text, View,FlatList,TouchableHighlight } from 'react-native';
import {getGrades} from '../screens/services/GradeServices'
import { Button, FAB } from '@rneui/themed';
import { ListItem } from '@rneui/themed';
import { Avatar } from '@rneui/themed';
import { useState } from 'react';

export const ListGrades =({navigation})=>{

    const [time,setTime]=useState();

    const refreshList=()=>{
        setTime(new Date().getTime());
    }

    const ItemGrade =({nota})=>{
        return (
            <TouchableHighlight onPress={()=>{
                navigation.navigate('GradeNav',{objeto:nota,fnRefresh:refreshList});

            }}>
                <ListItem bottomDivider>
                <Avatar
                    title={nota.subject.substring(0,1)}
                    containerStyle={{ backgroundColor: 'green' }}
                    rounded
                />
                <ListItem.Content>
                    <ListItem.Title>
                        {nota.subject}
                    </ListItem.Title>
                    
                </ListItem.Content>

                <ListItem.Content>
                    <ListItem.Title>
                    {nota.grade}
                    </ListItem.Title>
                </ListItem.Content>
                <ListItem.Chevron/>
            </ListItem>
            </TouchableHighlight>



        );
    }
    
    
    return(

        

        <View style={styles.container}>
            <FlatList
                data={getGrades()}
                renderItem={({item})=>{
                    return <ItemGrade  nota={item}  />
                }}  
                keyExtractor={(item)=>{
                    return item.subject;
                }}
                extraData={time}

            />
            <FAB
                title='+'
                placement='right'
                color='red'
                onPress={()=>{
                    navigation.navigate('GradeNav',{objeto:nota,fnRefresh:refreshList})
                }}
            />
            
        </View>

        
        // 

    );
}



const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'stretch',
      justifyContent: 'center',
    },
  });