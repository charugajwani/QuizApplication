import React from 'react';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import { Button } from '@material-ui/core';

export default class GetCourses extends React.Component {
    state = {
        courses: []
    }

    componentDidMount() {
        this.getAuthToken();
        // this.getCourses();
    }

    handleClick = () => {
        window.location=`${window.apiUrl}/ui/submitCourse`;
    }

    getAuthToken = () => {
        fetch(`${window.apiUrl}/authToken`, {
            method: "GET"
        }).then((resp) => resp.json()).then(this.setAuthToken).catch(function(error) {
            console.log(error);
        });
        // console.log(authToken);
        // let data = authToken.json();
        // this.setState({authToken: data.authToken});
    }

    setAuthToken = (data) => {
        this.setState({authToken: data.authToken});
        this.getCourses();
    } 

    getCourses = async () =>  {
        let courseList = await fetch(`${window.apiUrl}/quizApp/getCourses`, {
            method: "GET",
            headers: {
                "authToken": this.state.authToken
            }
        });
        let data = await courseList.json();
        console.log(data);
        this.setState({courses: data});
    };

    render() {
        return (
            <>
                <div className="courses">
                    <List component="nav" aria-label="main">
                        {this.state.courses.map(obj => (
                            <ListItem button>
                                <ListItemText primary={obj.courseName} />
                            </ListItem>
                        ))}
                    </List>
                </div>
                <div>
                    <Button variant="contained" color="primary" className="submit" onClick={this.handleClick}> Submit Course </Button>
                </div>
            </>
        );
    }
}

export class SubmitCourse extends React.Component {

    state = {
        courseName: ""
    }

    componentDidMount() {
        this.getAuthToken();
    }

    getAuthToken = async () => {
        let authToken = await fetch(`${window.apiUrl}/authToken`, {
            method: "GET"
        });
        let data = await authToken.json();
        this.setState({authToken: data.authToken});
    }

    handleClick = () => {
        this.submitQuestion();
    }

    handleChange = name => event => {
        this.setState({[name]: event.target.value});
    }

    submitQuestion = async () => {
        let urlParams = new URLSearchParams();
        urlParams.append('courseName', this.state.courseName);
        await fetch(`${window.apiUrl}/quizApp/submitCourse`, {
            method: "POST",
            headers: {
                "authToken": this.state.authToken
            },
            body: urlParams
        });
    }

    render() {
        return (
            <div className="login-form-container">
                <form id="submit-course-form" autoComplete="off">
                    <div className="input-container">
                        <TextField
                            id="courseName"
                            label="Course Name"
                            className="input"
                            value={this.state.courseName}
                            onChange={this.handleChange('courseName')}
                            margin="normal"
                        />
                    </div>
                    <Button variant="contained" color="primary" className="submit" onClick={this.handleClick}>
                        Submit
                    </Button>
                </form>
            </div>
        );
    }
}