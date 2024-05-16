
import { StyleSheet, Text, View } from 'react-native';
import { Button } from '@rneui/base';
import { Input } from '@rneui/themed';
import { Alert } from 'react-native';
import React, { useState } from 'react';
import {saveGrade,updateGrade} from '../screens/services/GradeServices'


export const GradeForm =({navigation})=>{
    let isNew=true;
    let subjectR
    let gradeR

    // if (route.params?.objeto != null) {
    //     isNew = false;
    //     subjectR = route.params.objeto.subject;
    //     gradeR = route.params.objeto.grade;
    //   }

    // if(route.params.objeto!=null){
    //     isNew=false;
    // };

    // if (!isNew) {
    //     subjectR = route.params.objeto.subject
    //     gradeR = route.params.objeto.grade
    // };

    const [subject,setSubject]=useState(subjectR);

    const [grade,setGrade]=useState(gradeR==null?null:gradeR+"");

    const [errorSubj,setErrorSub] = useState();

    const [errorGrades,setErrorGrades] = useState();

    let hasError=false;
    
    
// console.log(route.params.objeto);

    const save=()=>{
        setErrorGrades();
        setErrorSub();
        validate();
        if (!hasError) {
            if (isNew) {
                saveGrade({subject:subject, grade:grade});
            }else{
                updateGrade({subject:subject, grade:grade})
            }
            navigation.goBack();
            route.params.fnRefresh();
        }
        

}

// const validate=()=>{
//     if (subject==null || subject=="") {
//         setErrorSub("DEBE INGRESAR UNA MATERIA");
//         hasError=true;
//     }
//     let gradeFloat =parseFloat(grade)
//     if (grade==null || isNaN(gradeFloat) || grade<0 || grade>10) {
//         setErrorGrades("DEBE INGRESAR UNA NOTA ENTRE 0-10");
//         hasError=true;
//     }
// }
   
   return(
        <View style={styles.container}>
            <Input
               value={subject}
                onChangeText={setSubject}
                placeholder='Ejemplo:Matematicas'
                label='Materia'
                errorMessage={errorSubj}
                disabled={!isNew}
            /> 
            <Input
               value={grade}
                onChangeText={setGrade}
                placeholder='0-10'
                label='Nota'
                errorMessage={errorGrades}
            /> 

            <Button
                title='GUARDAR'
                icon={{
                    name:'save',
                    type:'font-awesome',
                    color:'white'
                }}
                buttonStyle={styles.saveBut}
                onPress={save}

            />
        </View>

    );
}


const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'center',
      justifyContent: 'center',
    },
    saveBut:{
        backgroundColor:'green'
    }
  });