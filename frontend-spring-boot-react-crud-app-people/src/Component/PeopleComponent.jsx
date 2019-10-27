import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik';
import PeopleDataService from '../service/PeopleDataService';



class PeopleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            personname: '',
            age: '',
            address: ''
            
        }

        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)

    }

    

    componentDidMount() {

        console.log(this.state.id)

        // eslint-disable-next-line
        if (this.state.id == -1) {
            return
        }

        PeopleDataService.retrievePerson(this.state.id)
            .then(response => this.setState({
                personname: response.data.personname,
                age: response.data.age,
                balance: response.data.balance,
                email: response.data.email,
                address: response.data.address,
            }))
    }

    validate(values) {
        let errors = {}
        if (!values.personname) {
            errors.personname = 'Enter a Name'
        } else if (values.personname.length < 0) {
            errors.description = 'Enter a Name'
        }

        return errors

    }

    onSubmit(values) {

        let person = {
            id: this.state.id,
            personname: values.personname,
            age: values.age,
            balance: values.balance,
            email: values.email,
            address: values.address,
            targetDate: values.targetDate
        }

        if (this.state.id === -1) {
            PeopleDataService.createPerson(person)
                .then(() => this.props.history.push('/people'))
        } else {
            PeopleDataService.updatePerson(this.state.id, person)
                .then(() => this.props.history.push('/people'))
        }

        console.log(values);
    }

    render() {

        let { personname, age, balance, email, address, id } = this.state

        return (
            <div>
                <h3>Person</h3>
                <div className="container">
                    <Formik
                        initialValues={{ id, age, balance, email, address, personname }}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="personname" component="div"
                                        className="alert alert-warning" />
                                    <fieldset className="form-group">
                                        <label>Id</label>
                                        <Field className="form-control" type="text" name="id" disabled />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Name</label>
                                        <Field className="form-control" type="text" name="personname" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Age</label>
                                        <Field className="form-control" type="text" name="age" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Balance</label>
                                        <Field className="form-control" type="text" name="balance" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Email</label>
                                        <Field className="form-control" type="text" name="email" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Address</label>
                                        <Field className="form-control" type="text" name="address" />
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>
        )
    }
}

export default PeopleComponent