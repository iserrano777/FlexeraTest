import React, { Component } from 'react'
import PeopleDataService from '../service/PeopleDataService';



class ListPeopleComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            people: [],
            message: null
        }
        this.deletePeopleClicked = this.deletePeopleClicked.bind(this)
        this.updatePeopleClicked = this.updatePeopleClicked.bind(this)
        this.addPeopleClicked = this.addPeopleClicked.bind(this)
        this.refreshPeople = this.refreshPeople.bind(this)
    }

    componentDidMount() {
        this.refreshPeople();
    }

    refreshPeople() {
        PeopleDataService.retrieveAllPeople()//HARDCODED
            .then(
                response => {
                    console.log(response);
                    this.setState({ people: response.data })
                }
            )
    }

    deletePeopleClicked(id) {
        PeopleDataService.deletePerson(id)
            .then(
                response => {
                    this.setState({ message: `Delete of people ${id} Successful` })
                    this.refreshPeople()
                }
            )

    }

    addPeopleClicked() {
        this.props.history.push(`/people/-1`)
    }

    updatePeopleClicked(id) {
        console.log('update ' + id)
        this.props.history.push(`/people/${id}`)
    }

    render() {
        console.log('render')
        return (
            <div className="container">
                <h3>All People</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Balance</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.people.map(
                                    person =>
                                        <tr key={person.id}>
                                            <td>{person.id}</td>
                                            <td>{person.personname}</td>
                                            <td>{person.age}</td>
                                            <td>{person.balance}</td>
                                            <td>{person.email}</td>
                                            <td>{person.address}</td>
                                            <td><button className="btn btn-success" onClick={() => this.updatePeopleClicked(person.id)}>Update</button></td>
                                            <td><button className="btn btn-warning" onClick={() => this.deletePeopleClicked(person.id)}>Delete</button></td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addPeopleClicked}>Add</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default ListPeopleComponent