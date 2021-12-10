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

const initialState = {username: "", password: "", authorization: "guest"};

function SignUp() {
    const [user, setUser] = useState(initialState);
    const [admin, setAdmin] = useState(true);

    const handleCheck = e => {
        setAdmin(!admin);
        console.log(admin);

        if (admin) {
            setUser(prevState => ({
                ...prevState,
                authorization: "admin"
            }));
        } else {
            setUser(prevState => ({
                ...prevState,
                authorization: "guest"
            }));
        }
    }
    
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
            const resp = await axios.post("http://localhost:8080/users", user);
            console.log(resp);
        } catch (err) {
            alert("User already used");
        }
    };

    return (
        <>
            <Container>
                <Wrapper>
                    <Content>
                        <Form action='/signin' onSubmit={ submitHandler }>
                            <Title> Sign Up </Title>
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
                            <Label htmlFor='for'>Admin?</Label>
                            <Input
                                value={user.authorization}
                                type='checkbox'
                                onChange={handleCheck}
                                name="authorization"
                            />
                            <Button type='submit'>Continue</Button>
                            <Text href="/signin">Already have a sign in?</Text>
                        </Form>
                    </Content>
                </Wrapper>
            </Container>
        </>
    );
}

export default SignUp