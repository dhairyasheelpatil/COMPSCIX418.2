


class Handler():
    """
    Define an interface for handling requests.
    Implement the successor link.
    """

    def __init__(self, successor=None):
        self._successor = successor

    def handle_request(self):
        pass


class BaseHandler(Handler):
    """
    Handle request, otherwise forward it to the successor.
    """

    def handle_request(self):
        if True:  # if can_handle:
            pass
        elif self._successor is not None:
            self._successor.handle_request()


class ExtendedHandler(Handler):
    """
    Handle request, otherwise forward it to the successor.
    """

    def handle_request(self):
        if False:  # if can_handle:
            pass
        elif self._successor is not None:
            self._successor.handle_request()


def main():
    base_handler = BaseHandler()
    extended_handler = ExtendedHandler(base_handler)
    extended_handler.handle_request()