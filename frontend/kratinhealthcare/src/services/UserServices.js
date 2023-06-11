import axiosServ from "./axiosServ"
const login = (user)=> {
   return axiosServ.post('user/login', user);
}

const adduser = (user)=> {
    return axiosServ.post('user/add', user);
 }

 const adddisease = (disease,userId)=> {
   console.log(userId)
   return axiosServ.post(`user/addDisease/${userId}`, disease);
 }

 const getAllDisease = (userId)=> {
  return axiosServ.get('user/getDisease',{
      params: {
         userId : userId
      }
   })
 }


export default {login,adduser, adddisease,getAllDisease}