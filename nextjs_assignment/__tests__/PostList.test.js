import { render, screen, fireEvent } from '@testing-library/react';
import PostList from '../component/PostList';

test('renders post titles', () => {
  const posts = [{ id: 1, title: 'Test', content: '...' }];
  render(<PostList posts={posts} onSelect={() => {}} />);
  expect(screen.getByText('Test')).toBeInTheDocument();
});

test('calls onSelect when clicked', () => {
  const posts = [{ id: 1, title: 'Test', content: '...' }];
  const handleSelect = jest.fn();
  render(<PostList posts={posts} onSelect={handleSelect} />);
  fireEvent.click(screen.getByText('Test'));
  expect(handleSelect).toHaveBeenCalledWith(posts[0]);
});
