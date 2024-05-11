sumar=()=>{
    let n1=recuperarCmp("dato1");
    let n2=recuperarCmp("dato2");
    let x1=parseInt(n1);
    let x2=parseInt(n2);
    console.log(x1+x2);
}

resta=(n1,n2)=>{
    return n1-n2;
}

ejecutarResta=()=>{
    let n1=recuperarFloat("dato1");
    let n2=recuperarFloat("dato2");
    console.log(resta(n1,n2));
}