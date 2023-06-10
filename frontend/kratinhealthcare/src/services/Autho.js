
const IsLogInUSer = ()=> {
    const user = JSON.parse(localStorage.getItem('userLoged'));
    if(user== null) {
        return false;
    }
    else {
        return true;
    }
}
export default IsLogInUSer;