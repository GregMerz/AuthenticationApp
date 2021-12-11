import {
    Container,
    Wrapper,
    Content,
    Form,
    Title,
    Label,
    Input,
    Button,
    Text
} from '../components/LoginElements.js';

import { useState } from 'react';
import axios from 'axios';

function SignIn() {
    const [user, setUser] = useState({username: "", password: "", authorization: ""});

    const handleChange = e => {
        const { name, value } = e.target;
        setUser(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const submitHandler = async e => {
        e.preventDefault();
        
        try {
            const resp = await axios.post("http://localhost:8080/validate", user);
            console.log(resp);
            alert("Correct login. You have " + resp.data.authorization + " authorization");
        } catch (err) {
            alert("Incorrect login");
        }
    };

    return (
        <>
            <Container>
                <Wrapper>
                    <Content>
                        <Form onSubmit={ submitHandler }>
                            <Title> Sign In </Title>
                            <Label htmlFor='for'>Username</Label>
                            <Input 
                                value={user.username}
                                type='text'
                                onChange={handleChange}
                                name="username"
                                required
                             />
                            <Label htmlFor='for'>Password</Label>
                            <Input 
                                value={user.password}
                                type='password' 
                                onChange={handleChange}
                                name="password"
                                required 
                            />
                            <Button type='submit'>Continue</Button>
                            <Text>Forgot password</Text>
                            <Text href='/signup'>Sign up</Text>
                        </Form>
                    </Content>
                </Wrapper>
            </Container>
        </>
    );
}

export default SignIn