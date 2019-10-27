import axios from 'axios'


const COURSE_API_URL = 'http://localhost:8080/app'

class PeopleDataService {

    retrieveAllPeople() {
        //console.log('executed service')
        return axios.get(`${COURSE_API_URL}/people`);
    }

    retrievePerson(id) {
        //console.log('executed service')
        return axios.get(`${COURSE_API_URL}/people/${id}`);
    }

    deletePerson(id) {
        //console.log('executed service')
        return axios.delete(`${COURSE_API_URL}/people/${id}`);
    }

    updatePerson(id, person) {
        //console.log('executed service')
        return axios.put(`${COURSE_API_URL}/people/${id}`, person);
    }

    createPerson(person) {
        //console.log('executed service')
        return axios.post(`${COURSE_API_URL}/people/`, person);
    }
}

export default new PeopleDataService()