import axios from 'axios';
const PHONE_FIND_ALL_REST_API_URL="http://localhost:8080/api/phones";
const COUNTRY_FIND_ALL_REST_API_URL="http://localhost:8080/api/countries"

class PhoneService{

    getPhones(country,state){
        return axios.get(PHONE_FIND_ALL_REST_API_URL+'?country='+country+'&state='+state);
    }

    getCountries(){
        return  axios.get(COUNTRY_FIND_ALL_REST_API_URL);
    }
    
}
export default new PhoneService();