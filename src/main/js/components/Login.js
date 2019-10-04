import Button from '@material-ui/core/Button';
import React from 'react';
import TextField from '@material-ui/core/TextField';

export default class Login extends React.Component {
    state = {
        username: "",
        password: ""
    }

    handleChange = name => event => {
        this.setState({[name]: event.target.value});
    }

    handleClick = () => {
        this.login();
    }

    login = async () => {
        let urlParams = new URLSearchParams();
        urlParams.append('username', this.state.username);
        urlParams.append('password', this.state.password);
        let authTokenResp = await fetch(`${window.apiUrl}/doLogin`, {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: urlParams
        });
        let data = await authTokenResp.json();
        // console.log(data);
        if(data.authToken != undefined) {
            this.setState({authToken: data.authToken});
            window.location = `${window.apiUrl}/ui/courses`
        } else {
            this.setState({error: data.error});
        }
    };

    render() {
        return (
            <div className="login-form-container">
                <div className="login-form">
                    <form id="login-form" autoComplete="off">
                        <div className="username-container input-container">
                            <TextField
                                id="username"
                                label="Email Address"
                                className="username input"
                                value={this.state.username}
                                onChange={this.handleChange('username')}
                                margin="normal"
                            />
                        </div>

                        <div className="password-container input-container">
                            <TextField
                                id="password"
                                label="Password"
                                className="password input"
                                value={this.state.password}
                                type="password"
                                onChange={this.handleChange('password')}
                                margin="normal"
                            />
                        </div>
                        <Button variant="contained" color="primary" className="submit" onClick={this.handleClick}>
                            Submit
                        </Button>
                    </form>
                </div>
            </div>
        );
    }
}