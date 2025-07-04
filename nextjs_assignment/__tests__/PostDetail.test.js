import { render, screen, fireEvent } from '@testing-library/react';
import PostDetail from '../component/PostDetail';

test('renders post detail', () => {
  const post = { id: 1, title: 'Test', content: 'Details here' };
  render(<PostDetail post={post} onClose={() => {}} />);
  expect(screen.getByText('Test')).toBeInTheDocument();
  expect(screen.getByText('Details here')).toBeInTheDocument();
});

test('calls onClose', () => {
  const post = { id: 1, title: 'Test', content: '...' };
  const handleClose = jest.fn();
  render(<PostDetail post={post} onClose={handleClose} />);
  fireEvent.click(screen.getByText('Close'));
  expect(handleClose).toHaveBeenCalled();
});
