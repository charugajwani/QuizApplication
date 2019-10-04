	import React from 'react';
	import ReactDOM from 'react-dom';
	import 'bootstrap/dist/css/bootstrap.min.css';
	import Login from './components/Login';
	import GetCourses, { SubmitCourse } from './components/Course';
	import { Route, BrowserRouter as Router } from 'react-router-dom';
	
	window.apiUrl = 'http://localhost:8080';
	
	class App extends React.Component {
	  render() {
		    return (
				<Login />
		    );
		}
	}

	const routing = (
		<Router>
		  <div>
			<Route exact path="/" component={App} />
			<Route path="/ui/courses" component={GetCourses} />
			<Route path="/ui/submitCourse" component={SubmitCourse} />
		  </div>
		</Router>
	)
	
	class Questions extends React.Component {
		state = {
			questions: []
		};
	  
		componentDidMount() {
			this.getQuestions();
		}
		
		getQuestions = async () =>  {
			let ques = await fetch(`${window.apiUrl}/quizApp/getQuestions`, {
				method: "GET",
				headers: {
					authToken: '647a6bb0-bfcc-46e4-b0fa-8be6768a87a7'
				}
			});
			let data = await ques.json();
			this.setState({questions: data});
		};
	  
		render(){
			return <div>Loaded Questions</div>
		}
	}
	
	ReactDOM.render(
		routing,
		document.getElementById('react')
	)

	
	export default App;