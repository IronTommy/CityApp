import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import Weather from './components/Weather';
import News from './components/News';
import VKPosts from './components/VKPosts';
import { Container, AppBar, Toolbar, Typography, Button } from '@mui/material';

function App() {
    return (
        <Router>
            <Container>
                <AppBar position="static">
                    <Toolbar>
                        <Typography variant="h6" style={{ flexGrow: 1 }}>
                            Городское Приложение
                        </Typography>
                        <Button color="inherit" component={Link} to="/">
                            Погода
                        </Button>
                        <Button color="inherit" component={Link} to="/news">
                            Новости
                        </Button>
                        <Button color="inherit" component={Link} to="/vk-posts">
                            Сахалин Новости
                        </Button>
                    </Toolbar>
                </AppBar>
                <Routes>
                    <Route path="/" element={<Weather />} />
                    <Route path="/news" element={<News />} />
                    <Route path="/vk-posts" element={<VKPosts />} />
                </Routes>
            </Container>
        </Router>
    );
}

export default App;
