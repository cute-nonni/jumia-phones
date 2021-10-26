import React, {useState, useEffect} from 'react'
import PhoneService from '../services/PhoneService';

function PhoneComponent() {

    const [phones, setPhones] = useState([]);
    const [loadingCountries, setLoadingCountries] = useState(true);
    const [selectedCountry, setSelectedCountry] = useState('');
    const [selectedState, setSelectedState] = useState('');

    const EMPTY_ITEM = { label: '', value: '' };
    const getCountries = () => {

        PhoneService.getCountries().then((response) => {

            let arr =[];
           arr.push(EMPTY_ITEM);
           let temp = response.data.map(( name ) => ({ label: name, value: name }))
           temp.map(( obj ) => (arr.push(obj)))
            setCountries(arr);
            setLoadingCountries(false);
            
        });
    };
    const [countries, setCountries] = useState([]);


    const changeCountryOption = (event) => { 

        setSelectedCountry(event.currentTarget.value);
        getPhones(event.currentTarget.value,document.getElementById('statedropDown').value);

    };

    const changeState = (event) => { 

        
        setSelectedState(event.currentTarget.value);

        getPhones(document.getElementById('countrydropDown').value,event.currentTarget.value);

    };
    
    


      if(loadingCountries){
  
        getCountries();
      }

      const getPhones = (selectedCountry,selectedState) => {
        PhoneService.getPhones(selectedCountry,selectedState).then((response) => {
            setPhones(response.data)
        });
    };


    useEffect(() => {
        getPhones('','')
    }, [])

   
 
    return (

        <div className = "container">
            
            <h1 className = "text-center">

            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-card-list" viewBox="0 0 16 16">
  <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
  <path d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm-1-5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zM4 8a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zm0 2.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0z"/>
</svg>
                    Phones Numbers </h1>


            
          
                <div className='container-fluid row w-50 p-3'> 
                    <div  className=' col-md-6'>Country 
                             <select  
                              className="form-select form-select-lg mb-3" aria-label=".form-select-lg example"  
                              id='countrydropDown' value={selectedCountry}      onChange={(e) =>changeCountryOption(e)}  >
                                {countries.map(({ label, value }) => ( <option key={value} value={value}> {label}  </option> ))}
                           </select>
                     </div>

                    <div className=' col-md-6' >State &nbsp;&nbsp;
                        <select  
                         className="form-select form-select-lg mb-3" aria-label=".form-select-lg example"
                        id='statedropDown' value={selectedState}      onChange={(e) =>changeState(e)}  >
                            <option key='0' value=''>   </option>  
                            <option key='1' value='Valid'> Valid  </option>                
                            <option key='2' value='Not Valid'> Not Valid  </option>                
                        </select>
                  </div>
                 </div>
                 
            <table className = "table table-striped">
                <thead>
                    <tr>
                        <th> Country</th>
                        <th> State</th>
                        <th> Country Code</th>
                        <th> Phone Number</th>
                    </tr>

                </thead>
                <tbody>
                    {
                        phones.map(
                                phone =>
                                <tr key = {phone.id}>
                                    <td> {phone.country }</td>
                                    <td> {phone.state }</td>
                                    <td> {phone.code }</td>    
                                    <td> {phone.phone }</td>

                                </tr>

                        )
                    }

                </tbody>


            </table>

        </div>
    )
}

export default PhoneComponent