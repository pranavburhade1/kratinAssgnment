import axiosServ from "./axiosServ"
const login = (user)=> {
   return axiosServ.post('user/login', user);
}

const adduser = (user)=> {
    return axiosServ.post('user/add', user);
 }


export default {login,adduser}